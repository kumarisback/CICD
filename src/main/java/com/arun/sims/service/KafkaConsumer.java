package com.arun.sims.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "incident-topic", groupId = "incident-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}