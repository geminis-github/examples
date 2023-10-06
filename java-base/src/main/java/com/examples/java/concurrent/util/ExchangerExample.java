package com.examples.java.concurrent.util;

import java.util.concurrent.Exchanger;

/**
 * Exchanger示例使用
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class ExchangerExample {

    /**
     * 自定义交换器
     */
    private static Exchanger<String> exchanger = new Exchanger<>();

    private static class LiuBeiTask implements Runnable {
        @Override
        public void run() {
            try {
                // 发送并接受来自另外一个线程的消息（可超时）
                String sunQuanMessage = exchanger.exchange("你好，我是刘备，你可以把你妹妹孙尚香，许配给我吗？");
                System.out.println("刘备收到消息：" + sunQuanMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SunQuanTask implements Runnable {
        @Override
        public void run() {
            try {
                // 发送并接受来自另外一个线程的消息（可超时）
                String liuBeiMessage = exchanger.exchange("好的，没问题，我这就把小妹送过去。");
                System.out.println("孙权收到消息：" + liuBeiMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread one = new Thread(new LiuBeiTask());
        Thread two = new Thread(new SunQuanTask());
        one.start();
        two.start();
        one.join();
        two.join();
    }

}
