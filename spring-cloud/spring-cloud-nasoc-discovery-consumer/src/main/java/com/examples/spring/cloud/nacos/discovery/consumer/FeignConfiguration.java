package com.examples.spring.cloud.nacos.discovery.consumer;

import org.springframework.context.annotation.Bean;

/**
 * feign配置类
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class FeignConfiguration {

    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

}
