package com.examples.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal使用
 *
 * 说明：大概相当于一个Map一样使用，只不过没有key（因为当前线程就是key），并且每个线程的ThreadLocal都是不一样的
 */
public class ThreadLocalExample {

    static ThreadLocal<HelloTask> threadLocal = new ThreadLocal<>();

    static class HelloTask {
        private String name;
        public HelloTask (String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        threadLocal.set(new HelloTask("main"));
        exec.execute(() -> {
            threadLocal.set(new HelloTask("jack")); // 不同线程设置的变量值是不一样的
            System.out.println("OneThread: " + threadLocal.get());
            threadLocal.remove(); // 使用完remove避免内存泄漏和加快内存释放
        });
        exec.execute(() -> {
            threadLocal.set(new HelloTask("mark"));
            System.out.println("TwoThread: " + threadLocal.get());
            threadLocal.remove();
        });
        exec.shutdown();
        System.out.println("主线程结束：" + threadLocal.get());
    }

}
