package com.examples.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal使用
 * 说明：大概相当于一个Map一样使用，只不过没有key（因为当前线程就是key），并且每个线程的ThreadLocal都是不一样的
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class ThreadLocalExample {

    /**
     * 不初始化的方式创建
     */
    private static ThreadLocal<HelloTask> threadLocal = new ThreadLocal<>();

    /**
     * 通过重写initialValue方法也可以
     */
    private static ThreadLocal<HelloTask> threadLocalImp = new ThreadLocal<>() {
        @Override
        protected HelloTask initialValue() {
            return new HelloTask("imp");
        }
    };

    private static class HelloTask {
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
        ExecutorService exec = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        threadLocal.set(new HelloTask("main"));
        exec.execute(() -> {
            threadLocal.set(new HelloTask("jack"));
            System.out.println("OneThread: " + threadLocal.get());
            // 使用完remove避免内存泄漏和加快内存释放
            threadLocal.remove();
        });
        exec.execute(() -> {
            threadLocal.set(new HelloTask("mark"));
            System.out.println("TwoThread: " + threadLocal.get());
            threadLocal.remove();
        });
        exec.shutdown();
        System.out.println("主线程结束1：" + threadLocal.get());
        System.out.println("主线程结束2：" + threadLocalImp.get());
    }

}
