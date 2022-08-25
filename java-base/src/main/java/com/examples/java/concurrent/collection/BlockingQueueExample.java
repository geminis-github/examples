package com.examples.java.concurrent.collection;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 阻塞容器模拟生产者消费者
 */
public class BlockingQueueExample {

    static BlockingQueue<String> queue = new ArrayBlockingQueue(3);

    // 生产者
    static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    // 生产数据
                    String data = productData();
                    System.out.println(Thread.currentThread().getName() + ": 生产了一个数据 " + data);
                    // 数据放入队列
                    queue.put(data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者
    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    // 消费数据
                    String data = queue.take();
                    TimeUnit.SECONDS.sleep(1); // 模拟延迟
                    System.out.println(Thread.currentThread().getName() + ": 消费 " + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static String productData () throws InterruptedException{
        // 模拟正式环境的时间损耗
        TimeUnit.SECONDS.sleep(3);
        return new Random().nextInt(100) + "";
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        // producers
        exec.execute(new Thread(new Producer(), "one"));
        exec.execute(new Thread(new Producer(), "two"));
        // consumer
        exec.execute(new Thread(new Consumer(), "aaa"));
        exec.execute(new Thread(new Consumer(), "bbb"));
        exec.execute(new Thread(new Consumer(), "ccc"));
        exec.shutdown();
        while (!exec.isTerminated()) {

        }
        System.out.println("main end");
    }

}
