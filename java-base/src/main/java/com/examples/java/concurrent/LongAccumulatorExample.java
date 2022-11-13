package com.examples.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * LongAccumulator使用示例
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class LongAccumulatorExample {
    public static void main(String[] args) throws Exception {
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);
        ExecutorService executor = Executors.newFixedThreadPool(8);
        // 创建10个线程执行任务,注意这里的任务不能保证执行的顺序,所以对执行顺序有要求的需求不能使用此场景
        IntStream.range(1, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));
        Thread.sleep(2000);
        System.out.println(accumulator.getThenReset());
        executor.shutdown();
    }
}
