package com.springkafka.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @KafkaListener(topics = "${message.topic.name}", groupId = "${monitor.kafka.consumer.groupid}")
    public void consumer(String order) {
        System.out.println("Order: " + order);
    }

//    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
//    public void consumer(ConsumerRecord<String, String> consumerRecord) {
//        System.out.println("key: " + consumerRecord.key());
//        System.out.println("Headers: " + consumerRecord.headers());
//        System.out.println("Partion: " + consumerRecord.partition());
//        System.out.println("Order: " + consumerRecord.value());
//    }
}