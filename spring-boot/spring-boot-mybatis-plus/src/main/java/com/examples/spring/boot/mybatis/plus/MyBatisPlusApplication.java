package com.examples.spring.boot.mybatis.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot-plus 使用示例，注意使用了MyBatisPlusJoin，并且配置了自定义的SqlSession，需要加上配置：sessionFactory.setGlobalConfig(new GlobalConfig().setSqlInjector(new MPJSqlInjector()));
 *
 * @see <a href="https://blog.csdn.net/renpeng301/article/details/124665330">Spring Boot 3.x- MybatisPlus集成</a>
 * @author Thinking9527
 * @date 2023-06-09 13:55
 */
@SpringBootApplication
@org.mybatis.spring.annotation.MapperScan(basePackages = "com.examples.spring.boot.mybatis.plus.mapper")
public class MyBatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusApplication.class);
    }

}
