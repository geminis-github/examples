package com.examples.spring.boot.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TestController {

    @GetMapping("/info")
    public String info() {
        log.info("info ...");
        return "ok123";
    }

}
