package com.examples.java.design.factory;

/**
 * 华为-手机
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class HuaweiPhone implements Phone {

    @Override
    public void call() {
        System.out.println("huawei call");
    }

}
