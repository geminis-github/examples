package com.examples.spring.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:58
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/info")
    private String info() {
        return "ok";
    }

}
