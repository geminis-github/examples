package com.examples.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ThreadLocal使用
 * 说明：大概相当于一个Map一样使用，只不过没有key（因为当前线程就是key），并且每个线程的ThreadLocal都是不一样的
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class ThreadLocalExample {

    private static ThreadLocal<HelloTask> threadLocal = new ThreadLocal<>();

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
        System.out.println("主线程结束：" + threadLocal.get());
    }

}
