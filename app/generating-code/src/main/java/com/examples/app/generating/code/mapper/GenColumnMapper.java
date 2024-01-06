package com.examples.app.generating.code.mapper;

import com.examples.app.generating.code.common.annotation.DS;
import com.examples.app.generating.code.common.base.BasePlusMapper;
import com.examples.app.generating.code.domain.GenColumnDO;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.examples.app.generating.code.common.enums.DataSourceType.MASTER;
import static com.examples.app.generating.code.common.enums.DataSourceType.SLAVE;

/**
 * 表字段信息-Mapper
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:53
 */
@Repository
public interface GenColumnMapper extends BasePlusMapper<GenColumnDO> {

    /**
     * mysql-查询表字段信息，根据数据库名称和表名称
     *
     * @param databaseName 库名称
     * @param tableName 表名称
     * @return 字段信息列表
     */
    @DS(value = MASTER)
    List<GenColumnDO> selectMySqlColumnListByTableName(String databaseName, String tableName);

    /**
     * oracle-查询表字段信息，根据数据库名称和表名称
     *
     * @param databaseName 库名称
     * @param tableName 表名称
     * @return 字段信息列表
     */
    @DS(value = SLAVE)
    List<GenColumnDO> selectOracleColumnListByTableName(String tableName);

}
