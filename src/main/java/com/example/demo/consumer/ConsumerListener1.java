package com.example.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者1（监听topic1队列）
 */
@Component

public class ConsumerListener1 {

    @KafkaListener(topics = "${spring.kafka.producer.myTopic1}")
    public void listen(ConsumerRecord<String,String> record) {
        System.out.println(record);
        String value = record.value();
        System.out.println("消费者1接收到消息：" + value);
    }
}
