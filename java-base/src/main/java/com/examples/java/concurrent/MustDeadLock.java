package com.examples.java.concurrent;

/**
 * 必然会发生死锁的情况
 *
 * @author Thinking9527
 * @date 2023-09-16 3:40
 */
public class MustDeadLock implements Runnable {

    public int flag;
    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " that flag is " + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("Thread one obtains two locks.");
                }
            }
        }
        if (flag == 2) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("Thread two obtains two locks.");
                }
            }
        }
    }

    public static void main(String[] args) {
        MustDeadLock r1 = new MustDeadLock();
        MustDeadLock r2 = new MustDeadLock();
        r1.flag = 1;
        r2.flag = 2;
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();
        // 由于它发生了死锁，在没有干预的情况下，程序在运行后不会停止
    }

}
