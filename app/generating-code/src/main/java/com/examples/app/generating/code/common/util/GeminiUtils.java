package com.examples.app.generating.code.common.util;

import com.examples.app.generating.code.common.exception.ServiceException;

import static com.examples.app.generating.code.common.Constants.MYSQL_TYPE;
import static com.examples.app.generating.code.common.Constants.ORACLE_TYPE;

/**
 * @author liangjinlong-CT00345
 * @date 2023-12-27 9:29
 */
public class GeminiUtils {

    private GeminiUtils() {

    }

    /**
     * Retrieve the database name from the JDBC URL, which must be either Oracle or MySQL.
     *
     * @param jdbcUrl url
     * @return databaseName
     */
    public static String getDBNameByUrl(String jdbcUrl) {
        String dbType = getDBTypeByUrl(jdbcUrl);
        if (MYSQL_TYPE.equals(dbType)) {
            int paramsStartIndex = jdbcUrl.indexOf("?");
            int dbNameEndIndex = (paramsStartIndex > -1) ? paramsStartIndex : jdbcUrl.length();
            return jdbcUrl.substring(jdbcUrl.lastIndexOf("/") + 1, dbNameEndIndex);
        } else if (ORACLE_TYPE.equals(dbType)) {
            int lastColon = jdbcUrl.lastIndexOf(":");
            int lastSlash = jdbcUrl.lastIndexOf("/");
            int endIndex = (lastColon > lastSlash) ? lastColon : jdbcUrl.length();
            return jdbcUrl.substring(lastSlash + 1, endIndex);
        }
        throw new IllegalArgumentException("The URL is not MySQL or Oracle.");
    }

    /**
     * 根据URL获取数据库类型
     *
     * @param jdbcUrl 数据库连接字符串
     * @return 数据库类型数字：1=MYSQL，2=ORACLE
     */
    public static String getDBTypeByUrl(String jdbcUrl) {
        if (jdbcUrl.startsWith("jdbc:mysql://")) {
            return MYSQL_TYPE;
        }
        if (jdbcUrl.startsWith("jdbc:oracle:thin:@")) {
            return ORACLE_TYPE;
        }
        throw new ServiceException("not allowed db type.");
    }

    /**
     * 根据URL获取数据库的主机路径信息
     *
     * @param url 连接字符串
     * @return 主机信息
     */
    public static String getDBHostByUrl(String url) {
        // 正则表达式匹配主机名和端口号
        String regex = "://(.*?)(:\\d+)?/";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            // 返回主机名和端口号
            return matcher.group(1) + (matcher.group(2) != null ? matcher.group(2) : "");
        }
        return "Invalid JDBC URL";
    }

}
