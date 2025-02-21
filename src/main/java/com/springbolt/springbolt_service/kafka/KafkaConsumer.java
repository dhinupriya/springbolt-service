package com.springbolt.springbolt_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaConsumer {
    @KafkaListener(topics = "user-topic")
    public void listen(String message) {

        System.out.println("Received: " + message);
    }
}
