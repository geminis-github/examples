package com.examples.java.nd;

/**
 * 速度计算
 *
 * @author liangjinlong9527
 * @date 2023-05-22 17:41
 */
public class VelocityCalculation {

    /**
     * 重力加速度常数
     */
    private static final Double GRAVITATIONAL_ACCELERATION = 9.8;

    public static void main(String[] args) {
        // 加速度倍数G
        int asg = 1;
        // 总里程（km）
        double sum = 0;
        // 速度（km/s）
        double speed = 0;
        // 总时间（s）
        int times = (10 * 60) / 2;
        // 加速
        for (int i = 0; i < times; i++) {
            speed += (asg * GRAVITATIONAL_ACCELERATION);
            sum += (speed / 1000);
        }
        sum = sum * 2;
        System.out.println("sum: " + sum);
    }

}
