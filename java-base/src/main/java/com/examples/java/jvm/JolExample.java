package com.examples.java.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * JOL打印对象内存布局
 */
public class JolExample {

    String name;
    Integer age;

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
