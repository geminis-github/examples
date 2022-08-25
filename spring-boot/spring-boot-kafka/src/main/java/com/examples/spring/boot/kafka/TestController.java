package com.examples.spring.boot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/test/{message}")
    public String test (@PathVariable("message") String message) {
        messageProducer.send(message);
        return "success";
    }

}
