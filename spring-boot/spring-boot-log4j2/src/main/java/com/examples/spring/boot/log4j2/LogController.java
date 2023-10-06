package com.examples.spring.boot.log4j2;

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
@RequestMapping("/log")
@Slf4j
public class LogController {

    @GetMapping("/all")
    private String all() {
        log.trace("log hello trace");
        log.debug("log hello debug");
        log.info("log hello info");
        log.warn("log hello warn");
        log.error("log hello error");
        return "ok";
    }

}
