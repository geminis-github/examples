package com.examples.app.generating.code.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.examples.app.generating.code.common.entity.GenDefaultInfo;
import com.examples.app.generating.code.common.base.BasePlusEntity;
import com.examples.app.generating.code.domain.GenTableDO;

import java.time.LocalDateTime;

import static com.examples.app.generating.code.common.Constants.MY_ID;

/**
 * 代码生成工具类
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-27 10:16
 */
public class GenUtils {

    /**
     * 雪花算法生成组件
     */
    private static final Snowflake SNOWFLAKE = IdUtil.getSnowflake(1, 1);

    /**
     * 初始化表信息
     *
     * @param table  业务表信息
     */
    public static void initTable(GenTableDO table, GenDefaultInfo config) {
        // 类名称
        table.setClassName(StrUtil.upperFirst(StrUtil.toCamelCase(table.getTableName())));
        // 包名称
        table.setPackageName(config.getPackageName());
        // 模块名称
        table.setModuleName(config.getModuleName());
        // 业务名称，默认使用表名称
        table.setBusinessName(table.getTableName());
        // 功能名称，默认使用表注释名称
        table.setFunctionName(table.getTableComment().replace("表", ""));
        // 功能作者，代码注释的作者
        table.setFunctionAuthor(config.getAuthor());
        // 数据库主机
        table.setDbHost(config.getDbHost());
        // 设置数据库类型：MYSQL,ORACLE
        table.setDbType(config.getDbType());
        // 设置库名称（库名称or模式名称）
        table.setLibraryName(config.getLibraryName());
        // 基础实体路径
        table.setBaseEntityPath(config.getBaseEntityPath());
        // 基础Mapper路径
        table.setBaseMapperPath(config.getBaseMapperPath());
        // 基础Service路径
        table.setBaseServicePath(config.getBaseServicePath());
        // 基础ServiceImpl路径
        table.setBaseServiceImplPath(config.getBaseServiceImplPath());
        // 基础Controller路径
        table.setBaseControllerPath(config.getBaseControllerPath());
        // 设置基础信息
        setCreateEntityInfo(table);
    }

    public static <T extends BasePlusEntity> void setCreateEntityInfo(T entity) {
        entity.setId(SNOWFLAKE.nextId());
        entity.setCreatedBy(MY_ID);
        entity.setUpdatedBy(MY_ID);
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
    }

    public static <T extends BasePlusEntity> void setUpdateEntityInfo(T entity) {
        entity.setUpdatedBy(MY_ID);
        entity.setUpdateTime(LocalDateTime.now());
    }

    /**
     * 表名转换成Java字段名称
     *
     * @param name 表名称
     * @return 类名
     */
    public static String convertCamelName(String name) {
        return StrUtil.lowerFirst(StrUtil.toCamelCase(name));
    }

}
