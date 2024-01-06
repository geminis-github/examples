package com.examples.app.generating.code.service;

import com.examples.app.generating.code.common.base.BasePlusService;
import com.examples.app.generating.code.domain.GenColumnDO;
import com.examples.app.generating.code.domain.GenTableDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 业务表信息-Service
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:53
 */
@Repository
public interface GenTableService extends BasePlusService<GenTableDO> {

    /**
     * 同步表字段信息
     *
     * @param tableToColumnMap 表名称和字段信息
     * @return 是否同步成功
     */
    boolean importColumnByTableNames(Map<String, List<GenColumnDO>> tableToColumnMap);

    /**
     * 同步表信息（更新不会覆盖已经设置的信息，只会同步表的信息，比如表注释）
     *
     * @param tableNames 表名称列表
     * @param list
     * @return 是否同步成功
     */
    boolean importTableByNames(List<String> tableNames, List<GenTableDO> list);

    /**
     * 查询所有的表信息
     *
     * @return 所有表信息
     */
    List<GenTableDO> listTables();

}
