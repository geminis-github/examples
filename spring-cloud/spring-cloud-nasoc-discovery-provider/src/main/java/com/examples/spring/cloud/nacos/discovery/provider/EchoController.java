package com.examples.spring.cloud.nacos.discovery.provider;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 提供者控制器接口
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
@RestController
public class EchoController {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @GetMapping("/sleep")
    public String sleep() {
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "hello Nacos Discovery " + string;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        if (b == 0) {
            return String.valueOf(0);
        } else {
            return String.valueOf(a / b);
        }
    }

    @GetMapping("/zone")
    public String zone() {
        Map<String, String> metadata = nacosDiscoveryProperties.getMetadata();
        return "provider zone " + metadata.get("zone");
    }

}
