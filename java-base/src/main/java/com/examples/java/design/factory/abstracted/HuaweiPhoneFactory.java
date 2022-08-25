package com.examples.java.design.factory.abstracted;

import com.examples.java.design.factory.HuaweiPhone;
import com.examples.java.design.factory.Phone;

/**
 * 华为-手机-工厂
 */
public class HuaweiPhoneFactory extends PhoneFactory {

    @Override
    Phone producePhone() {
        return new HuaweiPhone();
    }

}
