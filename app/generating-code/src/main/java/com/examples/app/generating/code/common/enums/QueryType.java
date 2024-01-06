package com.examples.app.generating.code.common.enums;

import lombok.Getter;

/**
 * 字段查询枚举类型
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:09
 */
@Getter
public enum QueryType {

    EQUALS("等于"),
    NOT_EQUALS("不等于"),
    GREATER_THAN("大于"),
    GREATER_THAN_EQUALS("大于等于"),
    LESS_THAN("小于"),
    LESS_THAN_EQUALS("小于等于"),
    LIKE_ALL("全LIKE"),
    LIKE_LEFT("左LIKE"),
    LIKE_RIGHT("右LIKE"),
    NOT_LIKE("非LIKE"),
//    NOT_LIKE_LEFT("左非LIKE"),
//    NOT_LIKE_RIGHT("右非LIKE"),
    BETWEEN("BETWEEN"),
    IN("IN"),
    NOT_IN("NOT IN");

    private final String name;

    QueryType(String name) {
        this.name = name;
    }

}
