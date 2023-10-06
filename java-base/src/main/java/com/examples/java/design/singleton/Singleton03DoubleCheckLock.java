package com.examples.java.design.singleton;

/**
 * 双重锁检查懒汉模式（DCL）
 * 优点：1、线程安全，2、延迟加载
 * 缺点：1、由于JVM底层模型原因，偶尔会出问题，不建议使用
 * 说明：由于jvm存在乱序执行功能，DCL也会出现线程不安全的情况
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class Singleton03DoubleCheckLock {

    /**
     * 私有化构造器
     */
    private Singleton03DoubleCheckLock() {
        // 抛出异常防止通过反射创建实例
        throw new RuntimeException("Instance creation is not allowed");
    }

    /**
     * 声明静态实例对象，延迟进行实例化（确保可见性），赋值null解决DCL失效问题
     */
    private volatile static Singleton03DoubleCheckLock INSTANCE = null;

    /**
     * 通过公有的静态方法获取实例
     *
     * @return 实例
     */
    public static Singleton03DoubleCheckLock getInstance() {
        // 第一重判断（增加效率：防止所有线程都是串行化的执行）
        if (INSTANCE == null) {
            // 这一段有可能有很多个线程进入到这里去竞争锁
            // 加锁
            synchronized (Singleton03DoubleCheckLock.class) {
                // 第二重判断（防止多次实例化：因为可能会有多个线程一起进入同步块外的if，如果在同步块内不进行二次检验的话就会生成多个实例了）
                if (INSTANCE == null) {
                    // 因为 new 对象这个操作不是一个原子操作，需要增加volatile解决可见性问题，可以防止避免拿到没完成初始化的对象，从而保证了线程安全
                    INSTANCE = new Singleton03DoubleCheckLock();
                }
            }
        }
        return INSTANCE;
    }

}
