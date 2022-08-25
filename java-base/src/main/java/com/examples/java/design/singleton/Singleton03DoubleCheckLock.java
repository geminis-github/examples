package com.examples.java.design.singleton;

/**
 * 双重锁懒汉模式（DCL）
 *
 * 优点：1、线程安全，2、延迟加载
 * 缺点：1、由于JVM底层模型原因，偶尔会出问题，不建议使用
 * 说明：由于jvm存在乱序执行功能，DCL也会出现线程不安全的情况
 */
public class Singleton03DoubleCheckLock {

    /** 私有化构造器 */
    private Singleton03DoubleCheckLock() {
        // 抛出异常防止通过反射创建实例
        throw new RuntimeException("Instance creation is not allowed");
    }

    /** 声明静态实例对象，延迟进行实例化（确保可见性） */
    private volatile static Singleton03DoubleCheckLock INSTANCE = null; // 赋值null解决DCL失效问题

    /** 通过公有的静态方法获取实例 */
    public static Singleton03DoubleCheckLock getInstance() {
        if (INSTANCE == null) { // 第一重判断
            synchronized (Singleton03DoubleCheckLock.class) { // 加锁
                if (INSTANCE == null) { // 第二重判断（因为可能会有多个线程一起进入同步块外的if，如果在同步块内不进行二次检验的话就会生成多个实例了）
                    INSTANCE = new Singleton03DoubleCheckLock();
                }
            }
        }
        return INSTANCE;
    }

}
