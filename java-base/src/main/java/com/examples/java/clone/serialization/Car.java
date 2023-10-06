package com.examples.java.clone.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 汽车类
 *
 * @author Thinking9527
 * @date 2023-05-22 22:29
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

    @Serial
    private static final long serialVersionUID = 6303629656112016967L;

    private String brand;

    private Integer maxSpeed;

}
