package com.examples.java.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 判断线程池是否完成了所有任务
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class ExecutorTerminatedExample {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            final int num = i;
            exec.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(20));
                    System.out.println("thread " + num + " done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // 使用isTerminated的前提是调用了shutdown方法，否则会导致死锁（关闭线程不在接受新任务）
        exec.shutdown();
        // 第一种方式：循环判断线程池任务是否完成
//        while (!exec.isTerminated()) {
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println("检查是否执行完成。。。");
//        }
        // 第二种方式：等待X秒(结束条件: 执行完成、超时、抛出异常)
        try {
            if (!exec.awaitTermination(10, TimeUnit.SECONDS)) { // 等待X秒，直到所有任务完成
                System.out.println("1、线程池未在规定时间内完成所有任务，强制关闭");
                exec.shutdownNow(); // 超时后强制关闭线程池
            } else {
                System.out.println("2、线程池内所有任务已完成");
            }
        } catch (InterruptedException e) {
            System.out.println("3、等待线程池关闭时被中断");
            exec.shutdownNow();
        }
    }

}
