package com.examples.java.clone.thirdparty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 金箍棒
 *
 * @author Thinking9527
 * @date 2023-05-23 0:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JinGuBang implements Serializable {

    @Serial
    private static final long serialVersionUID = 76728853678456720L;

    private Integer weight;
    private String color;
    private Double length;

}
