package com.examples.java.concurrent.util;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier使用示例（比CountDownLatch好的地方是可以重复使用）
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class CyclicBarrierExample {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    static class SoldierReportTask implements Runnable {
        private int num;
        public SoldierReportTask(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            System.out.println(num + " number start, ready work");
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                cyclicBarrier.await(); // 只有超过一定数量的线程到达这里的时候，才会执行后续的代码
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(num + " number soldier standby");
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.execute(new SoldierReportTask(i));
        }
        exec.shutdown();
        while (!exec.isTerminated()) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("...");
        }
        System.out.println("done works");
    }

}
