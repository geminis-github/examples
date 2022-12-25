package com.examples.spring.boot.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * machine-entity
 *
 * @author liangjinlong9527
 * @date 2022-12-13 21:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machine {

    private String name;
    private Integer age;
    private Boolean sex;

}
