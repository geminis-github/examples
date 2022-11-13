package com.examples.java.design.singleton;

/**
 * 静态内部类模式（推荐）
 * 优点：1、线程安全，2、调用效率高，3、可以延迟加载
 * 缺点：外部类和内部类的传参问题（外部无法传递参数进去，例如Context这种参数）
 * 说明：静态内部类只有在外部类初始化的时候才会初始化(详见类的加载时机)
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class Singleton04StaticInnerClasses {

    /** 私有化构造器 */
    private Singleton04StaticInnerClasses() {
        // 抛出异常防止通过反射创建实例
        throw new RuntimeException("Instance creation is not allowed");
    }

    /** 通过公有的静态方法获取实例 */
    public static Singleton04StaticInnerClasses getInstance() {
        return Holder.INSTANCE;
    }

    /** 声明私有静态内部类  */
    private static class Holder {
        /** 持有外部类的实例 */
        private static final Singleton04StaticInnerClasses INSTANCE = new Singleton04StaticInnerClasses();
    }

}
