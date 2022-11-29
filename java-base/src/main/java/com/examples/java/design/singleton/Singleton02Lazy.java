package com.examples.java.design.singleton;

/**
 * 懒汉式模式
 * 优点：1、因为是需要的时候才进行初始化对象，避免了不必要的创建
 * 缺点：1、线程不安全，需要在获取实例的方法上增加synchronized关键字来保证同步（效率会降低）
 * 说明：以时间换空间，在多线程环境下存在风险。
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class Singleton02Lazy {

    /**
     * 私有化构造器
     */
    private Singleton02Lazy() {
        // 抛出异常防止通过反射创建实例
        throw new RuntimeException("Instance creation is not allowed");
    }

    /**
     * 声明静态实例对象，延迟进行实例化
     */
    private static Singleton02Lazy INSTANCE;

    /**
     * 通过公有的静态方法获取实例，增加同步关键字
     *
     * @return 实例
     */
    public synchronized static Singleton02Lazy getInstance() {
        // 需要的时候才进行创建
        if (INSTANCE == null) {
            INSTANCE = new Singleton02Lazy();
        }
        return INSTANCE;
    }

}
