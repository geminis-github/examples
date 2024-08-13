package com.examples.java.design.filter;

import lombok.Data;

/**
 * 主对象类
 *
 * @author liangjinlong-CT00345
 * @date 2024-04-25 15:23
 */
@Data
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

}
