package com.examples.spring.boot.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot-plus 使用示例
 *
 * @see <a href="https://blog.csdn.net/renpeng301/article/details/124665330">Spring Boot 3.x- MybatisPlus集成</a>
 * @author liangjinlong9527
 * @date 2023-06-09 13:55
 */
@SpringBootApplication
@MapperScan(basePackages = "com.examples.spring.boot.mybatis.plus.mapper")
public class MyBatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusApplication.class);
    }

}
