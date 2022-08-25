package com.examples.java.design.singleton;

/**
 * 饿汉式模式
 *
 * 优点：1、线程安全（因为只会在类加载到JVM的时候进行初始化），2、调用效率高
 * 缺点：1、无法延迟加载，不需要的时候也可能会被创建出来，浪费资源（立刻的创建对象，单例的过程可能会比较慢）
 * 说明：以空间换时间，故不存在线程安全问题。
 */
public class Singleton01Hungry {

    /** 私有化构造器 */
    private Singleton01Hungry() {
        // 抛出异常防止通过反射创建实例
        throw new RuntimeException("Instance creation is not allowed");
    }

    /** 初始化一个静态的实例 */
    private static final Singleton01Hungry INSTANCE = new Singleton01Hungry();

    /** 通过公有的静态方法获取实例 */
    public static Singleton01Hungry getInstance() {
        return INSTANCE;
    }

}
