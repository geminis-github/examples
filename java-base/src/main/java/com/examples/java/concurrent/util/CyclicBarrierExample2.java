package com.examples.java.concurrent.util;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch使用示例2
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class CyclicBarrierExample2 {

    /**
     * 当计数器为0时，立即执行
     */
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("汇总线程：" + Thread.currentThread().getName() + " 任务合并。"));

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        // 将线程A添加到线程池
        executorService.submit(() -> {
            try {
                System.out.println("线程A：到达屏障点");
                cyclicBarrier.await();
                System.out.println("线程A：退出屏障点");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // 将线程B添加到线程池
        executorService.submit(() -> {
            try {
                System.out.println("线程B：到达屏障点");
                cyclicBarrier.await();
                System.out.println("线程B：退出屏障点");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // 关闭线程池
        executorService.shutdown();
    }

}
