package com.springkafka.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class OrderProducer {

    @Value("${message.topic.name}")
    private String orderTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void send(final @RequestBody String order) {
        kafkaTemplate.send(orderTopic, order).addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(">>>>>>>>>> " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println(result.getRecordMetadata().offset());
            }
        });
    }
}
