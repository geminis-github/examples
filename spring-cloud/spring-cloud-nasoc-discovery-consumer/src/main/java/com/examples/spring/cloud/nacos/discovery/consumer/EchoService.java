package com.examples.spring.cloud.nacos.discovery.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * EchoFeignClient服务
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@FeignClient(name = "nacos-discovery-provider", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface EchoService {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);

    @GetMapping("/divide")
    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    @GetMapping("/zone")
    String zone();
}
