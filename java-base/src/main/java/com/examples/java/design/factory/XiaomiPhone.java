package com.examples.java.design.factory;

/**
 * 小米-手机
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class XiaomiPhone implements Phone {

    @Override
    public void call() {
        System.out.println("xiaomi call");
    }

}
