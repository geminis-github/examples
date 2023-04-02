package com.examples.spring.boot.data.mongodb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@RestController
public class TestController {

    @GetMapping(value = "/hi")
    public String hi () {
        return "hello";
    }

}
