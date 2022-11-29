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

    private static class SimpleRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 如果还没有showdown,则由主线程来执行
            if (!executor.isShutdown()) {
                System.out.println("线程池: 我忙不过来了,你自己执行");
                r.run();
            }
        }
    }

    /**
     *  自定义线程工厂
     */
    private static class SimpleThreadFactory implements ThreadFactory {
        private final AtomicInteger count = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            // 设置自定义的线程参数
            Thread thread = new Thread(r);
            // 计数器
            int c = count.incrementAndGet();
            // 设置线程名称
            thread.setName("simple-thread-" + c);
            // 设置高优先级
            thread.setPriority(Thread.MAX_PRIORITY);
            return thread;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 核心线程数量
        int corePoolSize = 2;
        // 最大线程数量
        int maximumPoolSize = 5;
        // 存活时间
        int keepAliveTime = 60;
        // 存活时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        // 阻塞队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(3);
        // 自定义的ThreadFactory
        ThreadFactory threadFactory = new SimpleThreadFactory();
        // 自定义拒绝策略
        RejectedExecutionHandler handler = new SimpleRejectedExecutionHandler();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
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
