package com.examples.java.design.factory.staticed;

import com.examples.java.design.factory.Phone;

/**
 * 3、静态工厂方法
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
