package com.arun.sims.service;

import com.arun.sims.model.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaProducer kafkaProducer;
    private final KafkaTemplate<String, String> kafkaTemplate;


    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void logIncidentToKafka(Incident incident) {
        kafkaProducer.sendMessage("incident-topic", incident.toString());
    }
}
