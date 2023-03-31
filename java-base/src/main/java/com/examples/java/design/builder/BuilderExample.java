package com.examples.java.design.builder;

/**
 * Builder模式使用演示，使用效果和原理同lombok插件
 *
 * @see <a href="https://blog.csdn.net/xiaokanfuchen86/article/details/124798818">Java Builder模式（设计模式之Builder模式）</a>
 * @author liangjinlong9527
 * @date 2023-03-07 23:17
 */
public class BuilderExample {

    public static void main(String[] args) {
        UserInfo target = UserInfo.builder()
                .name("jack")
                .build();
    }

}
