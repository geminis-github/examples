package com.examples.spring.boot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@Slf4j
@Component
public class MessageConsumer {

    private static final String TOPIC_NAME = "springTest";
    private static final String GROUP_ID = "springTestGroup";

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void listen(ConsumerRecord<String, String> record, Acknowledgment ack) {
        // 获取消息
        String value = record.value();
        //手动提交offset
        ack.acknowledge();
        log.info("listen a message = {}", value);
    }

}
