package com.examples.app.generating.code.service.impl;

import com.examples.app.generating.code.common.base.BasePlusServiceImpl;
import com.examples.app.generating.code.common.entity.GenDefaultInfo;
import com.examples.app.generating.code.domain.GenColumnDO;
import com.examples.app.generating.code.mapper.GenColumnMapper;
import com.examples.app.generating.code.service.GenColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.examples.app.generating.code.common.Constants.MYSQL_TYPE;
import static com.examples.app.generating.code.common.Constants.ORACLE_TYPE;

/**
 * 表字段信息-ServiceImpl
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:53
 */
@Service
public class GenColumnServiceImpl extends BasePlusServiceImpl<GenColumnMapper, GenColumnDO> implements GenColumnService {

    @Autowired
    private GenDefaultInfo genDefaultInfo;

    /**
     * 根据表名称查询字段列表
     *
     * @param tableName 表名称
     * @return 表字段信息
     */
    @Override
    public List<GenColumnDO> listColumnByTableNames(String tableName) {
        List<GenColumnDO> columnList = new ArrayList<>();
        if (MYSQL_TYPE.equals(genDefaultInfo.getDbType())) {
            columnList = baseMapper.selectMySqlColumnListByTableName(genDefaultInfo.getLibraryName(), tableName);
        }
        if (ORACLE_TYPE.equals(genDefaultInfo.getDbType())) {
            columnList = baseMapper.selectOracleColumnListByTableName(tableName);
        }
        return columnList;
    }

}
