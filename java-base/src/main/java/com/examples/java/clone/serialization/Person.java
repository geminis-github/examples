package com.examples.java.clone.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 打工人，需要被序列化和反序列化
 *
 * @author Thinking9527
 * @date 2023-05-22 22:34
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 4093651074329191599L;

    private String name;
    private int age;
    private Car car;

}
