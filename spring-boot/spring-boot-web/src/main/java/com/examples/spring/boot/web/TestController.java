package com.examples.spring.boot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/info")
    private String getName() {
        return "ok";
    }

    @GetMapping("/log")
    private String log() {
        log.trace("log hello trace");
        log.debug("log hello debug");
        log.info("log hello info");
        log.warn("log hello warn");
        log.error("log hello error");
        return "ok";
    }

}
