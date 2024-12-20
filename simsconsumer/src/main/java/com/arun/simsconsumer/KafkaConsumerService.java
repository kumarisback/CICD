package com.arun.simsconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    ObjectMapper objectMapper= new ObjectMapper();
    @KafkaListener(topics = "jvmInfo", groupId = "sims-consumer")
    public void listenJvmInfo(ConsumerRecord<String, Object> record) {
        System.out.println("Received message metadata:");
        System.out.println("  Topic: " + record.topic());
        System.out.println("  Partition: " + record.partition());
        System.out.println("  Offset: " + record.offset());
        System.out.println("  Key: " + record.key());

        try {
            // Extract the message
            Object message = record.value();
            // Format the message as JSON
            String jsonMessage = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
            System.out.println("Message content:\n" + jsonMessage);
        } catch (JsonProcessingException e) {
            System.err.println("Failed to parse message content.");
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "memoryInfo", groupId = "sims-consumer")
    public void listenMemoryInfo(ConsumerRecord<String, Object> record) {
        System.out.println("Received message metadata:");
        System.out.println("  Topic: " + record.topic());
        System.out.println("  Partition: " + record.partition());
        System.out.println("  Offset: " + record.offset());
        System.out.println("  Key: " + record.key());

        try {
            // Extract the message
            Object message = record.value();
            // Format the message as JSON
            String jsonMessage = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
            System.out.println("Message content:\n" + jsonMessage);
        } catch (JsonProcessingException e) {
            System.err.println("Failed to parse message content.");
            e.printStackTrace();
        }
    }
}
