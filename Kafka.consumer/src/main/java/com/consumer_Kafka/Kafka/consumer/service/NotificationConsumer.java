package com.consumer_Kafka.Kafka.consumer.service;


import com.consumer_Kafka.Kafka.consumer.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {



    @KafkaListener(
            topics = "order-events",
            groupId = "notification-group"
    )
    public void consume(OrderEvent event) {

        System.out.println("Event Received : " + event.getEmail());

        String subject = "Order Status Update";

        String body =
                "Order ID : " + event.getOrderId() +
                        "\nStatus : " + event.getStatus();


    }
}

//
//Producer
//   |
//           | Sends JSON
//v
//Kafka Topic (order-events)
//   |
//v
//@KafkaListener
//   |
//v
//consume(OrderEvent event)
//   |
//           +--> Print Email
//   |
//           +--> Create Subject
//   |
//           +--> Create BodyCreate