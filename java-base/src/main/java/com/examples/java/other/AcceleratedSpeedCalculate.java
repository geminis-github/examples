package com.examples.java.other;

/**
 * 计算加速度距离
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class AcceleratedSpeedCalculate {

    public static void main(String[] args) {
        // 加速度
        double acc = 9.8 * 10;
        // 耗时
        int time = 60 * 15;
        // 行走里程
        double sum = 0;
        double speed = 0;
        for (int i = 0; i < time; i++) {
            if (i == (int)(time / 2)) {
                System.out.println("最高速 = " + (speed / 1000) + " km/s");
            }
            // 前半程
            if (i < time / 2) {
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
