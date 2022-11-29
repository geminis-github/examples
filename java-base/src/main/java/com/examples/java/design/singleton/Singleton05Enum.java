package com.examples.java.design.singleton;

/**
 * 枚举类模式（推荐）
 * 优点：1、线程安全，2、调用效率高，3、不能延时加载，4、可以天然的防止反射和反序列化调用
 * 缺点：non
 * 说明：具体见枚举底层原理
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public enum Singleton05Enum {

    /**
     * 枚举元素本身就是单例
     */
    INSTANCE

}
