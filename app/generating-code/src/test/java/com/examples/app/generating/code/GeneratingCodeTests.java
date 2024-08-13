package com.examples.app.generating.code;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.examples.app.generating.code.common.util.EntityUtils;
import com.examples.app.generating.code.common.util.VelocityInitializer;
import com.examples.app.generating.code.common.util.VelocityUtils;
import com.examples.app.generating.code.domain.GenColumnDO;
import com.examples.app.generating.code.domain.GenTableDO;
import com.examples.app.generating.code.entity.GenColumn;
import com.examples.app.generating.code.entity.GenTable;
import com.examples.app.generating.code.service.GenColumnService;
import com.examples.app.generating.code.service.GenTableService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Slf4j
@SpringBootTest(classes = GeneratingCodeApplication.class)
public class GeneratingCodeTests {

    private static final List<String> tableNames = List.of("DISPLAY_SCOPE_GROUP");
    @Autowired private GenTableService genTableService;
    @Autowired private GenColumnService genColumnService;

    /**
     * 根据表名称生成代码
     */
    @Test
    public void generatorCode() {
        this.importTableByNames();
        this.importColumnByTableNames();
        List<GenTableDO> genTableList = genTableService.list(Wrappers.lambdaQuery(GenTableDO.class).in(GenTableDO::getTableName, tableNames));
        for (GenTableDO genTable : genTableList) {
            GenTable rawGenTable = new GenTable();
            BeanUtils.copyProperties(genTable, rawGenTable);
            List<GenColumnDO> columnList = genColumnService.list(Wrappers.lambdaQuery(GenColumnDO.class).eq(GenColumnDO::getTableId, genTable.getId()));
            List<GenColumn> rawColumnList = EntityUtils.convertToRawList(columnList);
            for (GenColumn column : rawColumnList) {
                if (isNotBlank(column.getJavaField())) {
                    // 转换字段名称首字母为大写
                    column.setCapJavaField(StringUtils.capitalize(column.getJavaField()));
                }
            }
            rawGenTable.setColumns(rawColumnList);

            setBaseClassNameByPath(rawGenTable, genTable);

            VelocityInitializer.initVelocity();
            VelocityContext context = VelocityUtils.prepareContext(rawGenTable);
            List<String> templates = VelocityUtils.getTemplateList();
            String projectPath = "D:\\TestGenerate"; // todo change here
            String packagePath = genTable.getPackageName().replaceAll("\\.", "/") + "/";
            String modulePath = genTable.getModuleName().replaceAll("\\.", "/");
            String baseStr = projectPath + "/" + packagePath + modulePath;
            File baseFile = new File(baseStr);
            if (!baseFile.exists()) {
                baseFile.mkdirs();
            }
            Map<String, String> templateModuleNameMap = new HashMap<>();
            templateModuleNameMap.put("vm/java/Mapper.java.vm", "mapper");
            templateModuleNameMap.put("vm/java/Domain.java.vm", "entity");
            templateModuleNameMap.put("vm/java/Entity.java.vm", "domain");
            templateModuleNameMap.put("vm/java/Service.java.vm", "service");
            templateModuleNameMap.put("vm/java/ServiceImpl.java.vm", "service/impl");
            templateModuleNameMap.put("vm/xml/Mapper.xml.vm", "xml");
            Map<String, String> fileNameMap = new HashMap<>();
            fileNameMap.put("vm/java/Domain.java.vm", "DO");
            fileNameMap.put("vm/java/Entity.java.vm", "");

            for (String template : templates) {
                String moduleFileName = templateModuleNameMap.get(template);
                File moduleDir = new File(baseStr + "/" + moduleFileName);
                if (!moduleDir.exists()) {
                    moduleDir.mkdir();
                }
                String fileName = getFileNameByTemplate(template, genTable, fileNameMap);
                File moduleFile = new File(moduleDir.getAbsoluteFile()  + "\\" + fileName);
                if (moduleFile.exists()) {
                    log.warn("fileName = {} exists.", fileName);
                    return;
                } else {
                    try {
                        moduleFile.createNewFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                // 渲染模板
                StringWriter sw = new StringWriter();
                Template tpl = Velocity.getTemplate(template, "UTF-8");
                tpl.merge(context, sw);
                FileUtil.writeString(sw.toString(), moduleFile, "UTF-8");
            }
        }
    }

    /**
     * 同步表字段信息
     */
    @Test
    public void importColumnByTableNames() {
        Map<String, List<GenColumnDO>> tableToColumnMap = queryColumnListByTableNames(tableNames);
        genTableService.importColumnByTableNames(tableToColumnMap); // ljlmark 为什么这里@DS不生效？
    }

    /**
     * 插入或更新表信息（更新不会覆盖已经设置的信息，只会同步表的信息，比如表注释）
     */
    @Test
    public void importTableByNames() {
        List<GenTableDO> list = genTableService.listTables();
        genTableService.importTableByNames(tableNames, list); // ljlmark 为什么这里@DS不生效？
    }

    /**
     * 修改字段信息
     */
    @Test
    public void updateColumnInfo() {
        List<GenColumnDO> list = genColumnService.list(
                Wrappers
                        .lambdaQuery(GenColumnDO.class)
                        .eq(GenColumnDO::getTableId, 1742095288916643840L)
        );
        Assert.notEmpty(list, "List is empty.");
        for (GenColumnDO column : list) {
            column.setQueryed(true);
        }
        Boolean updateResult = genColumnService.saveOrUpdateBatch(list);
        Assert.isTrue(updateResult, "Update fail.");
    }

    /**
     * 修改表信息
     */
    @Test
    public void updateTableInfo() {
        GenTableDO entity = genTableService.getOne(Wrappers
                .lambdaUpdate(GenTableDO.class)
                .eq(GenTableDO::getTableName, tableNames.getFirst())
        );
        Assert.notNull(entity, "Entity data is null.");
        entity.setGenPath("/");
        boolean updateBool = genTableService.updateById(entity);
        Assert.isTrue(updateBool, "The update result be false.");
    }

    /**
     * 查询当前数据库or模式的表列表信息
     */
    @Test
    public void list() {
        List<GenColumnDO> columnList = genColumnService.listColumnByTableNames(tableNames.getFirst());
        List<GenTableDO> tableList = genTableService.listTables();
    }

    private Map<String, List<GenColumnDO>> queryColumnListByTableNames(List<String> tableNames) {
        Map<String, List<GenColumnDO>> result = new HashMap<>();
        for (String tableName : tableNames) {
            result.put(tableName, genColumnService.listColumnByTableNames(tableName));
        }
        return result;
    }

    private String getFileNameByTemplate(String template, GenTableDO genTable, Map<String, String> fileNameMap) {
        String defaultName = fileNameMap.get(template);
        String beforeName = template
                .replace(".vm", "")
                .replace("vm/", "");
        if (defaultName == null) {
            return genTable.getClassName() + beforeName.substring(beforeName.indexOf("/") + 1);
        } else {
            String suffixName = beforeName.substring(beforeName.indexOf("."));
            return genTable.getClassName() + defaultName + suffixName;
        }
    }

    /**
     * 根据基础类的路径设置基础类名称
     *
     * @param rawGenTable  封装对象
     * @param genTable 数据库对象
     */
    private void setBaseClassNameByPath(GenTable rawGenTable, GenTableDO genTable) {
        rawGenTable.setBaseEntityName(getNameByPath(genTable.getBaseEntityPath()));
        rawGenTable.setBaseMapperName(getNameByPath(genTable.getBaseMapperPath()));
        rawGenTable.setBaseServiceName(getNameByPath(genTable.getBaseServicePath()));
        rawGenTable.setBaseServiceImplName(getNameByPath(genTable.getBaseServiceImplPath()));
        rawGenTable.setBaseControllerName(getNameByPath(genTable.getBaseControllerPath()));
    }

    private String getNameByPath(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }

}
