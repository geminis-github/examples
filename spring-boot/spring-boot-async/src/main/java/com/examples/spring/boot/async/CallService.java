package com.examples.spring.boot.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * 异步方法服务
 *
 * @author Thinking9527
 * @date 2023-08-25 21:19
 */
@Service
@Slf4j
public class CallService {

    /**
     * 无返回值异步方法
     */
    @Async
    public void sendEmail() {
        log.info("start send email. " + Thread.currentThread().getName());
        // do send
        log.info("success send email.");
    }

    @Async
    public CompletableFuture<String> pullMsg() {
        String value = "success";
        return CompletableFuture.completedFuture(value);
    }

}
