package com.examples.app.generating.code.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量池
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-27 9:47
 */
public class Constants {

    public static final List<String> SUPER_COLUMN_NAME_LIST = List.of("id", "create_user", "create_time", "update_user", "update_time");

    /**
     * 我的名称
     */
    public static final String MY_NAME = "liangjinlong-CT00345";

    /**
     * 我的ID
     */
    public static final Long MY_ID = 1L;

    /**
     * 过滤的表前缀
     */
    public static final List<String> FILTER_TABLE_PREFIXES = List.of("gen_");

    /**
     * 过滤的表名称
     */
    public static final List<String> SPECIFIC_TABLE_NAMES = List.of("table1");

    /**
     * MySql数据库类型
     */
    public static final String MYSQL_TYPE = "MySql";

    /**
     * Oracle数据库类型
     */
    public static final String ORACLE_TYPE = "Oracle";

    /**
     * 初始化类型映射关系
     */
    public static final Map<String, String> DB_TYPE_MAPPING = new HashMap<>();

    static {
        DB_TYPE_MAPPING.put("INT", "Integer");
        DB_TYPE_MAPPING.put("SMALLINT", "Integer");
        DB_TYPE_MAPPING.put("MEDIUMINT", "Integer");
        DB_TYPE_MAPPING.put("BIGINT", "Long");
        DB_TYPE_MAPPING.put("VARCHAR", "String");
        DB_TYPE_MAPPING.put("CHAR", "String");
        DB_TYPE_MAPPING.put("TINYTEXT", "String");
        DB_TYPE_MAPPING.put("TEXT", "String");
        DB_TYPE_MAPPING.put("MEDIUMTEXT", "String");
        DB_TYPE_MAPPING.put("LONGTEXT", "String");
        DB_TYPE_MAPPING.put("DATE", "Date");
        DB_TYPE_MAPPING.put("DATETIME", "Date");
        DB_TYPE_MAPPING.put("TIMESTAMP", "Date");
        DB_TYPE_MAPPING.put("YEAR", "Integer");
        DB_TYPE_MAPPING.put("FLOAT", "Double");
        DB_TYPE_MAPPING.put("DOUBLE", "Double");
        DB_TYPE_MAPPING.put("DECIMAL", "BigDecimal");
        DB_TYPE_MAPPING.put("BOOLEAN", "Boolean");
        DB_TYPE_MAPPING.put("TINYINT", "Boolean");
        // oracle
        DB_TYPE_MAPPING.put("VARCHAR2", "String");
        DB_TYPE_MAPPING.put("NUMBER", "Integer");
    }


}
