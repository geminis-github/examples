package com.examples.spring.boot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * kafka消息生产者
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@Slf4j
@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC_NAME = "springTest";

    public void send (String message) {
        // key可以根据时机情况进行设置
        String key = "simpleKey";
        // 发送消息
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME, key, message);
        try {
            SendResult<String, String> sendResult = future.get();
            log.info("send message success = {}", message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
