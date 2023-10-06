package com.examples.spring.boot.rocketmq;

import com.alibaba.fastjson.JSON;
import com.examples.spring.boot.rocketmq.entity.Animal;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 动物-消费服务
 *
 * @author Thinking9527
 * @date 2023-05-21 21:33
 */
@Slf4j
@Component
public class AnimalConsumer {

    @Service
    @RocketMQMessageListener(topic = AnimalProducer.TOPIC_TEST, selectorExpression = "tag1", consumerGroup = "consumer_group_one")
    public class ConsumerSend implements RocketMQListener<Animal> {
        // 监听到消息就会执行此方法
        @Override
        public void onMessage(Animal user) {
            log.info("Listen to a message：animal={}", JSON.toJSONString(user));
        }
    }

}
