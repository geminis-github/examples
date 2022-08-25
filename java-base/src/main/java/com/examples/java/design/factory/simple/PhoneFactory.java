package com.examples.java.design.factory.simple;

import com.examples.java.design.factory.HuaweiPhone;
import com.examples.java.design.factory.Phone;
import com.examples.java.design.factory.XiaomiPhone;

/**
 * 手机-抽象工厂
 */
public class PhoneFactory {

    /**
     * 生产一步手机（通过参数名称生产一部手机，而不需要手动的去new某一个具体的手机）
     *
     * @param name 手机名称（huawei、xiaomi）
     * @return 手机产品
     */
    public Phone producePhone (String name) {
        return switch (name) {
            case "huawei" -> new HuaweiPhone();
            case "xiaomi" -> new XiaomiPhone();
            default -> null;
        };
    }

}
