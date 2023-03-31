package com.examples.java.design.factory.simple.staticed;

import com.examples.java.design.factory.Phone;

/**
 * 3、静态工厂方法
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class StaticFactoryExample {

    public static void main(String[] args) {
        // 通过静态方法构造
        Phone huaweiPhone = StaticPhoneFactory.producePhone("huawei");
        Phone xiaomiPhone = StaticPhoneFactory.producePhone("xiaomi");
        huaweiPhone.call();
        xiaomiPhone.call();
    }

}
