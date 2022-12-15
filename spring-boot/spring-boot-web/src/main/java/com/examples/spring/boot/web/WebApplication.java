package com.examples.spring.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot-web使用示例
 *
 * @see <a href="https://blog.csdn.net/zhanggqianglovec/article/details/125875072">actuator监控</a>
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
