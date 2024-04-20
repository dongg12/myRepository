package com.wd.kafka.controller;


import com.wd.kafka.constant.KafkaConstants;
import com.wd.kafka.req.DemoKafkaRequest;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaDemoController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 自动提交offset
     * @param request DemoKafkaRequest
     */
    @PostMapping("/demoKafka")
    public void kafkaDemo(@RequestBody DemoKafkaRequest request) {
        kafkaTemplate.send(new ProducerRecord<>(KafkaConstants.DEMO_TOPIC, request.getMessage()));
    }

    /**
     * 手动提交offset
     * @param request DemoKafkaRequest
     */
    @PostMapping("/demoAckKafka")
    public void kafkaAckDemo(@RequestBody DemoKafkaRequest request) {
        kafkaTemplate.send(KafkaConstants.DEMO_ACK_TOPIC, request.getMessage());
    }

    /**
     * 批量接收kafka消息进行处理
     * @param request DemoKafkaRequest
     */
    @PostMapping("/batchSendMessage")
    public void batchSendMessage(@RequestBody DemoKafkaRequest request) {
        kafkaTemplate.send(new ProducerRecord<>(KafkaConstants.DEMO_BATCH_TOPIC, request.getMessage()));
        kafkaTemplate.send(new ProducerRecord<>(KafkaConstants.DEMO_BATCH_TOPIC, request.getMessage() + "1"));
        kafkaTemplate.send(new ProducerRecord<>(KafkaConstants.DEMO_BATCH_TOPIC, request.getMessage() + "2"));
    }
}
