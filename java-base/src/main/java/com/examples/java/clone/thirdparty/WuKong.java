package com.examples.java.clone.thirdparty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 悟空-需要被克隆的对象
 *
 * @author liangjinlong9527
 * @date 2023-05-23 0:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WuKong implements Serializable {

    @Serial
    private static final long serialVersionUID = 76384431232856160L;

    private JinGuBang jinGuBang;
    private Integer age;
    private String name;

}
