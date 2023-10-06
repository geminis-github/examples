package com.examples.java.clone.thirdparty;

import cn.hutool.core.clone.Cloneable;
import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serial;

/**
 * 使用第三方类库进行克隆对象
 *
 * @author Thinking9527
 * @date 2023-05-23 0:48
 */
public class ThirdPartyExample {

    public static void main(String[] args) {
        // 原始对象
        WuKong rawWuKong = new WuKong(new JinGuBang(100, "#FF0000", 999.999), 8000, "sun");
        // hutool克隆
        WuKong hutoolCloneWuKong = ObjectUtil.cloneByStream(rawWuKong);
        hutoolCloneWuKong.setName("jack");
        // common-lang克隆
        WuKong lang3CloneWuKong = SerializationUtils.clone(rawWuKong);
        lang3CloneWuKong.setName("mark");
        System.out.println("raw: " + rawWuKong);
        System.out.println("jackWuKong: "+ hutoolCloneWuKong);
        System.out.println("markWuKong: "+ lang3CloneWuKong);
    }

}
