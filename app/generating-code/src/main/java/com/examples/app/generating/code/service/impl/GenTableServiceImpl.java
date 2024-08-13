package com.examples.app.generating.code.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.examples.app.generating.code.common.annotation.TableColumn;
import com.examples.app.generating.code.common.base.BasePlusServiceImpl;
import com.examples.app.generating.code.common.entity.GenDefaultInfo;
import com.examples.app.generating.code.common.exception.ServiceException;
import com.examples.app.generating.code.common.Constants;
import com.examples.app.generating.code.common.util.GenUtils;
import com.examples.app.generating.code.domain.GenColumnDO;
import com.examples.app.generating.code.domain.GenTableDO;
import com.examples.app.generating.code.mapper.GenTableMapper;
import com.examples.app.generating.code.service.GenColumnService;
import com.examples.app.generating.code.service.GenTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.examples.app.generating.code.common.Constants.DB_TYPE_MAPPING;
import static com.examples.app.generating.code.common.Constants.FILTER_TABLE_PREFIXES;
import static com.examples.app.generating.code.common.Constants.MYSQL_TYPE;
import static com.examples.app.generating.code.common.Constants.ORACLE_TYPE;
import static com.examples.app.generating.code.common.Constants.SPECIFIC_TABLE_NAMES;

/**
 * 业务表信息-ServiceImpl
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:53
 */
@Service
@Slf4j
public class GenTableServiceImpl extends BasePlusServiceImpl<GenTableMapper, GenTableDO> implements GenTableService {

    @Autowired private GenDefaultInfo genDefaultInfo;
    @Autowired private GenColumnService genColumnService;

    private static final Field[] GEN_COLUMN_DO_FIELDS = GenColumnDO.class.getDeclaredFields();

    /**
     * 同步表字段信息
     *
     * @param tableNames 表名称列表
     * @return 是否同步成功
     */
    @Override
    @Transactional
    public boolean importColumnByTableNames(Map<String, List<GenColumnDO>> tableToColumnMap) {
        if (tableToColumnMap == null || tableToColumnMap.isEmpty()) {
            throw new ServiceException("表名称列表不允许为空");
        }
        List<String> tableNames = new ArrayList<>(tableToColumnMap.keySet());
        List<GenTableDO> tableList = baseMapper.selectList(Wrappers.lambdaQuery(GenTableDO.class).in(GenTableDO::getTableName, tableNames));
        if (tableList.size() != tableNames.size()) {
            throw new ServiceException("有表名称未成功同步，请先同步完成表数据");
        }
        for (String tableName : tableNames) {
            GenTableDO genTable = baseMapper.selectOne(Wrappers.lambdaQuery(GenTableDO.class).eq(GenTableDO::getTableName, tableName));
            if (genTable == null) {
                throw new SecurityException("表名称不存在");
            }
            List<GenColumnDO> columnList = tableToColumnMap.get(tableName);
            // 根据字段名称查询是否存在记录，没有的话则插入，否则根据要求更新信息
            List<GenColumnDO> queryColumnList = genColumnService.list(Wrappers.lambdaQuery(GenColumnDO.class).eq(GenColumnDO::getTableId, genTable.getId()));
            Map<String, GenColumnDO> columnNaenMap = queryColumnList.stream().collect(Collectors.toMap(GenColumnDO::getColumnName, Function.identity()));
            for (GenColumnDO column : columnList) {
                GenColumnDO old = columnNaenMap.get(column.getColumnName());
                if (old == null) {
                    GenUtils.setCreateEntityInfo(column);
                    column.setTableId(genTable.getId());
                    column.setJavaType(DB_TYPE_MAPPING.get(column.getDataType().toUpperCase()));
                    column.setJavaField(GenUtils.convertCamelName(column.getColumnName()));
                    column.setSuperColumn(Constants.SUPER_COLUMN_NAME_LIST.contains(column.getColumnName()));
                    // 默认都可查询
                    column.setQueryed(true);
                    genColumnService.save(column);
                } else {
                    // 保留业务字段信息
                    GenUtils.setUpdateEntityInfo(old);
                    // 设置表字段信息
                    setTableColumnToOld(column, old);
                    genColumnService.updateById(old);
                }
            }
            log.info("table {} insert colum size = {}", tableName, columnList.size());
        }
        return true;
    }

    /**
     * 同步表信息（更新不会覆盖已经设置的信息，只会同步表的信息，比如表注释）
     *
     * @param tableNames 表名称列表
     * @param list 表格数据
     * @return 是否同步成功
     */
    @Override
    @Transactional
    public boolean importTableByNames(List<String> tableNames, List<GenTableDO> list) {
        if (tableNames == null || tableNames.isEmpty()) {
            throw new ServiceException("表名称列表不允许为空");
        }
        List<GenTableDO> tableList = list
                .stream()
                .filter(el -> tableNames.stream().anyMatch(tableName -> el.getTableName().equalsIgnoreCase(tableName)))
                .toList();
        if (tableList.isEmpty()) {
            tableList = baseMapper.selectList(Wrappers.lambdaQuery(GenTableDO.class).in(GenTableDO::getTableName, tableNames));
        }
        if (tableList.isEmpty()) {
            throw new ServiceException("表名称不存在");
        }
        int insertNum = 0;
        int updateNum = 0;
        for (GenTableDO item : tableList) {
            // 判断库名称和表名称判断是否存在，如果存在则设置ID
            GenTableDO query = baseMapper.selectOne(
                    Wrappers
                            .lambdaQuery(GenTableDO.class)
                            .eq(GenTableDO::getLibraryName, genDefaultInfo.getLibraryName())
                            .eq(GenTableDO::getTableName, item.getTableName())
            );
            if (query == null) {
                GenUtils.initTable(item, genDefaultInfo);
                insertNum += baseMapper.insert(item);
            } else {
                query.setTableComment(item.getTableComment());
                GenUtils.setUpdateEntityInfo(query);
                updateNum += baseMapper.updateById(query);
            }
        }
        log.info("insertNum = {}, updateNum = {}", insertNum, updateNum);
        return true;
    }

    /**
     * 查询所有的表信息
     *
     * @return
     */
    @Override
    public List<GenTableDO> listTables() {
        // 已经导入过的表名称
        List<String> existsTableNameList = baseMapper
                .selectList(
                        Wrappers
                                .lambdaQuery(GenTableDO.class)
                                .eq(GenTableDO::getDbHost, genDefaultInfo.getDbHost())
                                .eq(GenTableDO::getDbType, genDefaultInfo.getDbType())
                                .eq(GenTableDO::getLibraryName, genDefaultInfo.getLibraryName())
                )
                .stream()
                .map(GenTableDO::getTableName)
                .map(String::toLowerCase)
                .toList();
        List<GenTableDO> tableList = new ArrayList<>();
        // 判断数据库类型
        String dbTyp = genDefaultInfo.getDbType();
        String libraryName = genDefaultInfo.getLibraryName();
        if (MYSQL_TYPE.equals(dbTyp)) {
            tableList = baseMapper.selectMySqlTableListByDatabaseName(libraryName);
        }
        if (ORACLE_TYPE.equals(dbTyp)) {
            tableList = baseMapper.selectOracleTableList();
        }
        // 查询并且过滤非必要的表
        return tableList.stream()
                .filter(el -> FILTER_TABLE_PREFIXES.stream().noneMatch(prefix -> el.getTableName().toLowerCase().startsWith(prefix)))
                .filter(el -> !SPECIFIC_TABLE_NAMES.contains(el.getTableName().toLowerCase()))
                .filter(el -> !existsTableNameList.contains(el.getTableName().toLowerCase()))
                .toList();
    }

    /**
     * 设置新查询出来的表字段信息到原有的字段信息上，不覆盖业务字段的信息
     *
     * @param column 新查询出来的字段信息
     * @param old 原有的字段信息
     */
    private void setTableColumnToOld(GenColumnDO column, GenColumnDO old) {
        for (Field field : GEN_COLUMN_DO_FIELDS) {
            field.setAccessible(true);
            TableColumn tc = field.getAnnotation(TableColumn.class);
            if (tc != null) {
                try {
                    Object value = field.get(column);
                    field.set(old, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
