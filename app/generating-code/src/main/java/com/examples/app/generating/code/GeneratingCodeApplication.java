package com.examples.app.generating.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代码生成器项目，根据模板文件生成各种标准化的代码文件
 *
 * @author Thinking9527
 * @date 2023-12-23 21:34
 */
@SpringBootApplication
@org.mybatis.spring.annotation.MapperScan(basePackages = "com.examples.app.generating.code.mapper")
public class GeneratingCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratingCodeApplication.class, args);
    }

}
