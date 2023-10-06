package com.examples.java.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 部门信息
 *
 * @author Thinking9527
 * @date 2023-06-13 1:34
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private String name;
    private Integer level;
    private Integer employeeNumber;

}
