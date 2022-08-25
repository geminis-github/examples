package com.examples.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockCondition模拟生产者消费者
 */
public class LockConditionExample {

    Lock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition popCondition = lock.newCondition();
    private List<Integer> dataList = new ArrayList<>(); // 仓库

    /**
     * 生产者方法
     */
    public void put() {
        try {
            lock.lock();
            while (dataList.size() >= 3) {
                System.out.println("仓库数量超过3，不能进行生产 size:" + dataList.size());
                putCondition.await();
                System.out.println("生产者被唤醒");
            }
            dataList.add(dataList.size() + 1);
            System.out.println("生产者生产 1 个商品，当前 仓库 size:" + dataList.size());
            popCondition.signalAll(); // 通知消费者 消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者方法
     */
    public void pop() {
        try {
            lock.lock();
            while (dataList.size() == 0) {
                System.out.println("仓库无商品，不能进行消费 size:" + dataList.size());
                popCondition.await();
                System.out.println("消费者被唤醒");
            }
            dataList.remove(0);
            System.out.println("消费者消费1个商品，当前 仓库 size:" + dataList.size());
            putCondition.signalAll(); // 通知生产者生产
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockConditionExample test = new LockConditionExample();
        //生产者线程 1
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    test.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //生产者线程 2
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    test.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //消费者线程 1
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    test.pop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //消费者线程 2
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    test.pop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
