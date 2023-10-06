package com.examples.spring.boot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author Thinking9527
 * @date 2022-11-13 12:58
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor // 使用次注解可以替代@Autowried
public class TestController {

    private final TestService testService;

    @GetMapping("/info")
    public String info() {
        return "ok " + testService.hello();
    }

}
