package com.examples.java.other;

public class AcceleratedSpeedCalculate {

    public static void main(String[] args) {
        double acc = 9.8 * 10; // 加速度
        int time = 60 * 15; // 耗时
        double sum = 0; // 行走里程
        double speed = 0;
        for (int i = 0; i < time; i++) {
            if (i == (int)(time / 2)) {
                System.out.println("最高速 = " + (speed / 1000) + " km/s");
            }
            if (i < time / 2) { // 前半程
                speed += acc;
                sum += speed;
            } else { // 后半程
                speed -= acc;
                sum += speed;
            }
        }
        for (int i = 0; i < time / 2; i++) {

        }

        System.out.println("耗时 = " + (time) + " 秒, 里程 = " + (sum / 1000) + " km");
    }

}
