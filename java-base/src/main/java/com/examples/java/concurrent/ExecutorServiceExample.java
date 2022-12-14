package com.examples.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 对比手动创建线程和使用线程池的效率差距
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class ExecutorServiceExample {

    static final Random dom = new Random();

    static class SearchTask implements Runnable {
        @Override
        public void run() {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ": start task");
                int num = dom.nextInt(5) * 10;
                Thread.sleep(num);
                System.out.println(threadName + ": edn task " + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SearchTask searchTask = new SearchTask();
        int size = 1000;
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Thread(searchTask));
        }
        long before = System.currentTimeMillis();
//        // 手动创建线程
//        for (Thread thread : list) {
//            thread.start();
//            thread.join();
//        }
        // 线程池创建线程
        ExecutorService exec = new ThreadPoolExecutor(100, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < size; i++) {
            exec.execute(searchTask);
        }
        exec.shutdown();
        while (!exec.isTerminated()) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("...");
        }

        System.out.println("use time = " + (System.currentTimeMillis() - before));
    }

}
