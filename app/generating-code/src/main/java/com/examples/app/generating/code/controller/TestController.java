package com.examples.app.generating.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-23 21:35
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/info")
    public String info() {
        return "ok";
    }

}
