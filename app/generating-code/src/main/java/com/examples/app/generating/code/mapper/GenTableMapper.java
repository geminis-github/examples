package com.examples.app.generating.code.mapper;

import com.examples.app.generating.code.common.annotation.DS;
import com.examples.app.generating.code.common.base.BasePlusMapper;
import com.examples.app.generating.code.domain.GenTableDO;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.examples.app.generating.code.common.enums.DataSourceType.MASTER;
import static com.examples.app.generating.code.common.enums.DataSourceType.SLAVE;

/**
 * 业务表信息-Mapper
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:53
 */
@Repository
public interface GenTableMapper extends BasePlusMapper<GenTableDO> {

    /**
     * 查询MySql表名称列表，根据数据库名称
     *
     * @param databaseName 数据库名称
     * @return 数据库的表列表信息
     */
    @DS(value = MASTER)
    List<GenTableDO> selectMySqlTableListByDatabaseName(String databaseName);

    /**
     * 查询Oracle Schema中用户所有的表信息
     *
     * @return 数据库的表列表信息
     */
    @DS(value = SLAVE)
    List<GenTableDO> selectOracleTableList();

}
