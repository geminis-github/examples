package com.examples.java.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 演示线程中断的使用
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class ThreadInterruptExample {

    static int i = 0;

    public static void main(String[] args) throws Exception {
        Thread one = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) { // isInterrupted会对状态进行复位，即是调用两次该方法，第二次必然返回false
                try {
                    i++;
                    System.out.println("Adder: add i " + i);
                    TimeUnit.SECONDS.sleep(1); // 在睡眠的过程中被其他线程调用了中断，会抛出InterruptedException
                } catch (InterruptedException e) {
                    System.out.println("Adder: 捕获异常 " + Thread.interrupted()); // 这里会对状态进行复位，所以依旧是false
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Adder: 结束 " + Thread.interrupted());
        });
        one.start();
        Thread.sleep(3000);
        System.out.println("Main: 中断自增线程 " + one.isInterrupted());
        one.interrupt(); // 执行中断过程（自增线程现在正在阻塞状态，对阻塞状态的线程进行中断会抛出InterruptedException），注意这个步骤会唤醒正在阻塞状态的线程
        System.out.println("Main: 结束 " + one.isInterrupted());
    }

}
