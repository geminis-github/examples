package com.examples.java.concurrent.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore信号量演示使用
 */
public class SemaphoreExample {

    static int num = 3; // 三个停车位

    static Semaphore semaphore = new Semaphore(num);

    static class PartTask implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            try {
                semaphore.acquire(); // 获取许可
                int seconds = new Random().nextInt(10) + 5;
                System.out.println(name + "：进入停车位，停车 " + seconds + " 秒");
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + "：退出停车位");
                semaphore.release(); // 需要释放许可
            }
        }
    }

    static String[] names = new String[] { "刘备", "关羽", "张飞", "曹操", "司马懿", "郭嘉", "孙权", "孙坚", "孙尚香", "吕布" };

    public static void main(String[] args) throws Exception {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 有10辆车需要停车
            list.add(new Thread(new PartTask(), names[i]));
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
    }



}
