package com.examples.spring.boot.rocketmq;

import com.examples.spring.boot.rocketmq.entity.Animal;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 动物-生产服务
 *
 * @author Thinking9527
 * @date 2023-05-21 21:22
 */
@Slf4j
@Component
public class AnimalProducer {

    /**
     * topic名称
     */
    public static final String TOPIC_TEST = "rlt_test_topic";

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void send() {
        rocketMQTemplate.convertAndSend(TOPIC_TEST + ":tag1", buildAnimal());
    }

    private Animal buildAnimal() {
        Animal animal = new Animal();
        animal.setAge(10);
        animal.setName("jack");
        animal.setSex(false);
        animal.setWeight(123.455);
        return animal;
    }

}
