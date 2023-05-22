package com.examples.java.oom;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 示例朋友类，实现了反序列化接口和克隆接口
 *
 * @see CreateObjectWay
 * @author liangjinlong9527
 * @date 2023-04-11 23:43
 */
@Data
public class Friend implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Friend(String name) {
        this.name = name;
    }

    public Friend() {
    }
}
