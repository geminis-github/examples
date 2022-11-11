package com.examples.spring.boot.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {

    @Pointcut(value = "execution(* com.examples.spring.boot.aop.controller.*.*(..))")
    public void point1() {

    }

    @Before("point1()")
    public void before1 () {
        System.out.println("join before");
    }

}
