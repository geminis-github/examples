package com.examples.java.concurrent.util;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CountDownLatch使用示例
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable taskMain = () -> {
            try {
                countDownLatch.await();  // 挂起，等待AQS的state值为0时被唤醒，解锁继续执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("继续执行任务");
        };
        Runnable task1 = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();  // 将AQS的state值减1 (计数器减1)
            System.out.println("前置任务1完成");
        };

        Runnable task2 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown(); // 将AQS的state值减1 (计数器减1)
            System.out.println("前置任务2完成");
        };
        new Thread(taskMain).start();
        new Thread(task1).start();
        new Thread(task2).start();
    }

}
