package com.example.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者2（监听topic2队列）
 */
@Component

public class ConsumerListener2 {

    @KafkaListener(topics = "${spring.kafka.producer.myTopic2}")
    public void listen(ConsumerRecord<String,String> record) {
        System.out.println(record);
        String value = record.value();
        System.out.println("消费者2接收到消息：" + value);
    }
}
