package com.examples.spring.boot.common.util;

/**
 * 字符串工具类
 *
 * @author Thinking9527
 * @date 2023-06-02 11:04
 */
public class BusinessUtil {

    private BusinessUtil() {

    }

    /**
     * 工具版本
     */
    private static final String VERSION = "1.0";

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    public static String getVersion() {
        return VERSION;
    }

}
