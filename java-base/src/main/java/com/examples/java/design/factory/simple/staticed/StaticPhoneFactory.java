package com.examples.java.design.factory.simple.staticed;

import com.examples.java.design.factory.HuaweiPhone;
import com.examples.java.design.factory.Phone;
import com.examples.java.design.factory.XiaomiPhone;

/**
 * 静态工厂
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class StaticPhoneFactory {

    /**
     * 静态工厂方法
     *
     * @param name 手机类型
     * @return 手机产品
     */
    public static Phone producePhone (String name) {
        return switch (name) {
            case "huawei" -> new HuaweiPhone();
            case "xiaomi" -> new XiaomiPhone();
            default -> null;
        };
    }

}
