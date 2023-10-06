package com.examples.spring.cloud.nacos.discovery.consumer;

/**
 * Echo 降级服务
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String str) {
        return "echo fallback";
    }

    @Override
    public String divide(Integer a, Integer b) {
        return "divide fallback";
    }

    @Override
    public String zone() {
        return "zone fallback";
    }

}
