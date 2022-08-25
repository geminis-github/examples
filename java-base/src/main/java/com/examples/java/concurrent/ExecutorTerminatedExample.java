package com.examples.java.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 判断线程池是否完成了所有任务
 */
public class ExecutorTerminatedExample {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            exec.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    System.out.println("线程 " + num + " 完成任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown(); // 使用isTerminated的前提是调用了shutdown方法，否则会导致死锁
//        while (!exec.isTerminated()) { // 循环判断线程池任务是否完成
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println("检查是否执行完成。。。");
//        }
        exec.awaitTermination(100, TimeUnit.SECONDS); // 等待100秒(结束条件: 执行完成,超时,抛出异常)
        System.out.println("任务执行完成，主线程结束");
    }

}
