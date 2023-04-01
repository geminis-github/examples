package com.examples.spring.demo;

import com.examples.spring.demo.config.AppConfig;
import com.examples.spring.demo.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试用例类，此测试用例无法使用gradle运行，需要在 Build Tools里面配置使用IDEA启动，具体参考下方的文档
 *
 * @see <a href=https://blog.csdn.net/xingxincsdn/article/details/125647409>【问题】idea执行spring boot单元测试报错No tests found</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class SpringApplicationTest {

    @Test
    public void test01() {
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

    @Test
    public void test02() {
        BeanPostProcessor beanPostProcessor;
        ApplicationContextAware applicationContextAware;
    }

}
