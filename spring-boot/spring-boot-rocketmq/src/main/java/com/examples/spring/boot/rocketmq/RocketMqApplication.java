package com.examples.spring.boot.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RocketMQ使用示例
 *
 * @see <a href="https://blog.csdn.net/zhenweiyi/article/details/130722046">Spring boot 3.0整合RocketMQ及不兼容的问题</a>
 * @see <a href="https://blog.csdn.net/qq_36737803/article/details/112261352">RocketMQ与Springboot整合（rocketmq-spring-boot-starter）实战教程</a>
 * @author Thinking9527
 * @date 2023-05-21 21:13
 */
@SpringBootApplication
public class RocketMqApplication {

    public static void main(String[] args) {
        // todo No route info of this topic: rlt_test_topic
        SpringApplication.run(RocketMqApplication.class);
    }

}
