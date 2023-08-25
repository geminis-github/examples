package com.examples.java.clone.sample;

/**
 * 正确获得一个”可克隆的类“
 *
 * 1、实现Cloneable接口
 * 2、重写clone方法
 * 3、在clone方法中调用super.clone()方法
 * 4、clone方法中捕获异常
 *
 * @author liangjinlong9527
 * @date 2023-05-22 22:21
 */
public class IsCloneable implements Cloneable {

    @Override
    public IsCloneable clone() {
        try {
            return (IsCloneable) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
