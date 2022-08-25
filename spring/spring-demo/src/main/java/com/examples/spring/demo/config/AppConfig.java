package com.examples.spring.demo.config;

import com.examples.spring.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.examples.spring.demo") // 可以通过AnnotationConfigApplicationContext获取到开启了注解的Bean
public class AppConfig {

    @Bean
    public UserService userService () {
        return new UserService();
    }

}
