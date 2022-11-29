package com.examples.java.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * JOL打印对象内存布局
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class JolExample {

    private String name;
    private Integer age;

    public static void main(String[] args) {
        JolExample example = new JolExample();
        example.age = 1;
        example.name = "jack";
        // 加锁前
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
        synchronized (example) {
            // 加锁后
            System.out.println(ClassLayout.parseInstance(example).toPrintable());
        }

    }

}
