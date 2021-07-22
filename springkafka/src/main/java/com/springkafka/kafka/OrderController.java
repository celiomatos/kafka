package com.springkafka.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping()
    public void send(@RequestBody String order) {
        orderProducer.send(order);
    }
}
