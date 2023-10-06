package com.examples.spring.boot.mybatis.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot-tk 使用示例
 *
 * @see <a href="https://github.com/abel533/Mapper">github仓库</a>
 * @see <a href="https://mybatis.io/">tk mapper 官网</a>
 * @see <a href="">配置文档</a>
 * @author Thinking9527
 * @date 2022-12-13 15:53
 */
@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan("com.examples.spring.boot.mybatis.tk.mapper")
public class MyBatisTkApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyBatisTkApplication.class);
    }

}
