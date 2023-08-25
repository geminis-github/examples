package com.examples.java.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 雇员类
 *
 * @author liangjinlong9527
 * @date 2023-06-13 1:31
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private Integer age;
    private Boolean sex;

}
