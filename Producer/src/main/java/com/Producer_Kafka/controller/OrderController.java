package com.Producer_Kafka.controller;

import com.Producer_Kafka.dto.OrderEvent;
import com.Producer_Kafka.service.OrderProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")

public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String placeOrder(@RequestBody OrderEvent event) {

        producer.sendOrderEvent(event);

        return "Order Event Published Successfully";
    }
}