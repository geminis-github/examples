package com.examples.spring.boot.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
@RestController
public class TestController {

    @GetMapping(value = "/hi")
    public String hi () {
        return "hello";
    }

}
