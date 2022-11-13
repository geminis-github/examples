package com.examples.java.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池和自定义线程池工厂使用演示
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class ThreadFactoryAndExecutorExample {

    static class SimpleRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (!executor.isShutdown()) { // 如果还没有showdown,则由主线程来执行
                System.out.println("线程池: 我忙不过来了,你自己执行");
                r.run();
            }
        }
    }

    // 自定义线程工厂
    static class SimpleThreadFactory implements ThreadFactory {
        private final AtomicInteger count = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            // 设置自定义的线程参数
            Thread thread = new Thread(r);
            int c = count.incrementAndGet(); // 计数器
            thread.setName("simple-thread-" + c); // 设置线程名称
            thread.setPriority(Thread.MAX_PRIORITY); // 设置高优先级
            return thread;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // 核心线程数量
                5, // 最大线程数量
                60, // 存活时间
                TimeUnit.SECONDS, // 存活时间单位
                new ArrayBlockingQueue<>(3), // 阻塞队列
                new SimpleThreadFactory(), // 自定义的ThreadFactory
                new SimpleRejectedExecutionHandler() // 自定义拒绝策略
        );
        for (int i = 0; i < 15; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ": hello");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

}
