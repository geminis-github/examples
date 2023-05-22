package com.examples.spring.boot.rocketmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author liangjinlong9527
 * @date 2023-05-21 22:39
 */
@RestController
public class TestController {

    @Autowired
    private AnimalProducer animalProducer;

    @GetMapping(value = "hi")
    public String hi() {
        animalProducer.send();
        return "ok";
    }

}
