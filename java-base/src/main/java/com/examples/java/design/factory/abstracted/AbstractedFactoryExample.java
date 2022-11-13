package com.examples.java.design.factory.abstracted;

import com.examples.java.design.factory.Phone;

/**
 * 2、抽象工厂类-示例
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class AbstractedFactoryExample {

    public static void main(String[] args) {
        // 生产huawei手机
        PhoneFactory huaweiFactory = new HuaweiPhoneFactory();
        Phone huawei = huaweiFactory.producePhone();

        // 生产xiaomi手机
        PhoneFactory xiaomiFactory = new XiaomiPhoneFactory();
        Phone xiaomi = xiaomiFactory.producePhone();

        huawei.call();
        xiaomi.call();
    }

}
