package com.examples.spring.demo;

import com.examples.spring.demo.config.AppConfig;
import com.examples.spring.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}) // 加载spring核心配置类
public class SpringApplicationTest {

    @Test
    public void test01 () {
        // 获取Context
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 获取Bean
        UserService userServiceXml = xmlContext.getBean("userServiceXml", UserService.class);
        UserService userService = annotationContext.getBean("userService", UserService.class);
        // 业务方法
        userServiceXml.call();
        userService.call();
    }

}
