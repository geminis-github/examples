package com.examples.app.generating.code.common.util;

import com.examples.app.generating.code.domain.GenColumnDO;
import com.examples.app.generating.code.entity.GenColumn;
import com.examples.app.generating.code.entity.GenTable;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 模板处理工具类
 *
 * @author liangjinlong-CT00345
 * @date 2024-01-04 15:07
 */
public class VelocityUtils {

    /**
     * 设置模板变量信息
     *
     * @return 模板列表
     */
    public static VelocityContext prepareContext(GenTable genTable) {
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("tableName", genTable.getTableName());
        velocityContext.put("functionName", StringUtils.isNotEmpty(genTable.getFunctionName()) ? genTable.getFunctionName() : "【请填写功能名称】");
        velocityContext.put("ClassName", genTable.getClassName());
        velocityContext.put("className", StringUtils.uncapitalize(genTable.getClassName()));
        velocityContext.put("moduleName", genTable.getModuleName());
        velocityContext.put("BusinessName", StringUtils.capitalize(genTable.getBusinessName()));
        velocityContext.put("businessName", genTable.getBusinessName());
        velocityContext.put("basePackage", getPackagePrefix(genTable.getPackageName()));
        velocityContext.put("packageName", genTable.getPackageName());
        velocityContext.put("packagePath", genTable.getPackageName() + "." + genTable.getModuleName());
        velocityContext.put("author", genTable.getFunctionAuthor());
        velocityContext.put("datetime", getNowDateTime());
        velocityContext.put("importList", getImportList(genTable));
        velocityContext.put("columns", genTable.getColumns());
        velocityContext.put("table", genTable);
        // 主键信息
        velocityContext.put("pkColumn", genTable.getColumns().stream().filter(GenColumnDO::getPk).findFirst().get());
        return velocityContext;
    }


    /**
     * 获取模板信息
     *
     * @return 模板列表
     */
    public static List<String> getTemplateList() {
        List<String> templates = new ArrayList<>();
        templates.add("vm/java/Mapper.java.vm");
        templates.add("vm/java/Domain.java.vm");
        templates.add("vm/java/Entity.java.vm");
        templates.add("vm/java/Service.java.vm");
        templates.add("vm/java/ServiceImpl.java.vm");
        templates.add("vm/xml/Mapper.xml.vm");
        return templates;
    }


    /**
     * 根据列类型获取导入包
     *
     * @param genTable 业务表对象
     * @return 返回需要导入的包列表
     */
    public static Set<String> getImportList(GenTable genTable) {
        Set<String> importList = new HashSet<>();
        if (genTable.getColumns() == null) {
            return importList;
        }
        for (GenColumn column : genTable.getColumns()) {
            if ("BigDecimal".equals(column.getJavaType())) {
                importList.add("java.math.BigDecimal");
            }
            if ("Date".equals(column.getJavaField())) {
                importList.add("java.util.Date");
            }
        }
        return importList;
    }

    /**
     * 获取当前时间的到分钟数
     *
     * @return 格式化时间
     */
    public static String getNowDateTime() {
        // 创建一个Date对象
        Date date = new Date();
        // 创建一个SimpleDateFormat对象，并指定所需的格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // 使用format方法将Date对象转换成字符串
        return formatter.format(date);
    }

    /**
     * 获取包前缀
     *
     * @param packageName 包名称
     * @return 包前缀名称
     */
    public static String getPackagePrefix(String packageName) {
        int lastIndex = packageName.lastIndexOf(".");
        return StringUtils.substring(packageName, 0, lastIndex);
    }

}
