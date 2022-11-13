package com.examples.java.design.factory.abstracted;

import com.examples.java.design.factory.Phone;
import com.examples.java.design.factory.XiaomiPhone;

/**
 * 小米-手机-工厂
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class XiaomiPhoneFactory extends PhoneFactory {

    @Override
    Phone producePhone() {
        return new XiaomiPhone();
    }

}
