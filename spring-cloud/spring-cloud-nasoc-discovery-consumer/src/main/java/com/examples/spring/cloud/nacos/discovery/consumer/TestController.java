package com.examples.spring.cloud.nacos.discovery.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private EchoService echoService;

    @GetMapping("/echo")
    public String echo () {
        return echoService.echo("jack");
    }

    @GetMapping("/divide")
    public String divide (@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return echoService.divide(a, b);
    }

    @GetMapping("/zone")
    public String zone () {
        return echoService.zone();
    }

}
