package com.wd.kafka.listenerHandler;

import com.wd.kafka.constant.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class messageHandler {

    @KafkaListener(topics = KafkaConstants.DEMO_TOPIC,containerFactory = "kafkaListenerContainerFactory",groupId = KafkaConstants.GROUP_ID)
    public void handleMessage(ConsumerRecord<String,String> record){
        String message = record.value();
        log.info("收到消息: {}", message);
    }

    @KafkaListener(topics = KafkaConstants.DEMO_ACK_TOPIC, containerFactory = "ackContainerFactory",groupId = KafkaConstants.GROUP_ID)
    public void handleMessage(ConsumerRecord<String,String> record, Acknowledgment acknowledgment) {
        try {
            String message = record.value();
            log.info("收到消息: {}", message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            // 手动提交 offset
            acknowledgment.acknowledge();
        }
    }

    @KafkaListener(topics = KafkaConstants.DEMO_BATCH_TOPIC,containerFactory = "kafkaBatchContainerFactory",groupId = KafkaConstants.GROUP_ID)
    public void handleBatchMessage(List<ConsumerRecord<String, String>> recordList){
        for (ConsumerRecord<String, String> record: recordList) {
            log.info("收到消息: {}", record.value());
        }
    }
}
