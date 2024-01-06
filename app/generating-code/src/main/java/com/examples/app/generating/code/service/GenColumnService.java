package com.examples.app.generating.code.service;

import com.examples.app.generating.code.common.base.BasePlusService;
import com.examples.app.generating.code.domain.GenColumnDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 表字段信息-Service
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:53
 */
@Repository
public interface GenColumnService extends BasePlusService<GenColumnDO> {

    /**
     * 根据表名称查询字段列表
     *
     * @param tableNames 表名称
     * @return 表字段信息
     */
    List<GenColumnDO> listColumnByTableNames(String tableNames);

}
