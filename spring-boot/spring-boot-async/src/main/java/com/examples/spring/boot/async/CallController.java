package com.examples.spring.boot.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * 调用入口
 *
 * @author Thinking9527
 * @date 2023-08-25 21:19
 */
@RestController
@RequestMapping("/call")
@Slf4j
public class CallController {

    @Autowired private CallService callService;

    @GetMapping("/test01")
    public void test01() {
        log.info("thread name " + Thread.currentThread().getName());
    }

    @GetMapping("/test02")
    public void test02() {
        callService.sendEmail();
    }

    @GetMapping("/test03")
    public String test03() {
        try {
            // 获取返回值
            return callService.pullMsg().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
