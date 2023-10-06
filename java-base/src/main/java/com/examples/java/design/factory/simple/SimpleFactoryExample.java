package com.examples.java.design.factory.simple;

import com.examples.java.design.factory.Phone;

/**
 * 1、简单工厂类-示例
 * 说明：最简单的工厂模式，就单纯的抽象了产品而已，通过一个工厂构造出不同的Phone
 * 缺点：不灵活，增加了新的Phone之后，需要改动工厂类的代码，没有对工厂进行抽象，一个工厂生产了所有类型的手机
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class SimpleFactoryExample {

    public static void main(String[] args) {
        // 获取工厂
        PhoneFactory factory = new PhoneFactory();
        // 通过工厂构造产品，不用需要什么就new什么，可以隐藏或者封装构造产品的逻辑
        Phone phone = factory.producePhone("huawei");
        // 使用
        phone.call();
    }

}
