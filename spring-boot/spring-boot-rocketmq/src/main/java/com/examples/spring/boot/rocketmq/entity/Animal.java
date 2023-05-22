package com.examples.spring.boot.rocketmq.entity;

import lombok.Data;

/**
 * 动物消息实体类
 *
 * @author liangjinlong9527
 * @date 2023-05-21 21:17
 */
@Data
public class Animal {

    private String name;
    private Integer age;
    private Boolean sex;
    private Double weight;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", weight=" + weight +
                '}';
    }

}
