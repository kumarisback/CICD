package com.arun.sims.service;

import com.arun.sims.model.Client;
import com.arun.sims.model.JvmMemoryInfo;
import com.arun.sims.model.SystemMemoryInfo;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;


    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object message) {
        kafkaTemplate.send(topic,message);
    }

    @Scheduled(fixedRate = 2000) // Runs every 5 seconds
    public void checkMemoryUsage() {
        try {
            Runtime runtime = Runtime.getRuntime();

            // Convert memory values from bytes to MB
            long totalMemory = runtime.totalMemory() / (1024 * 1024);
            long freeMemory = runtime.freeMemory() / (1024 * 1024);
            long usedMemory = totalMemory - freeMemory;
            long maxMemory = runtime.maxMemory() / (1024 * 1024);
            System.out.printf(
                    "Total Heap Memory: %d MB%nFree Heap Memory: %d MB%nUsed Heap Memory: %d MB%nMax Heap Memory allowed: %d MB%n",
                    totalMemory, freeMemory, usedMemory, maxMemory);
            JvmMemoryInfo jvmMemoryInfo= new JvmMemoryInfo(totalMemory,freeMemory,usedMemory,maxMemory);
            kafkaTemplate.send("jvmInfo", jvmMemoryInfo.toString());
        } catch (Exception e) {
            System.err.println("Runtime not available: " + e.getMessage());
        }
    }

    @Scheduled(fixedRate = 4000) // Runs every 1 seconds
    public void checkSystemMemoryUsage() {
        try {
            OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            // Get system memory details in MB
            long totalPhysicalMemory = osBean.getTotalMemorySize() / (1024 * 1024);
            long freePhysicalMemory = osBean.getFreeMemorySize() / (1024 * 1024);
            long usedPhysicalMemory = totalPhysicalMemory - freePhysicalMemory;

            // Build a response
            System.out.printf(
                    "Total Physical Memory: %d MB%nFree Physical Memory: %d MB%nUsed Physical Memory: %d MB%n",
                    totalPhysicalMemory, freePhysicalMemory, usedPhysicalMemory);
            SystemMemoryInfo systemMemoryInfo= new SystemMemoryInfo(totalPhysicalMemory,freePhysicalMemory,usedPhysicalMemory);
            kafkaTemplate.send("memoryInfo", systemMemoryInfo);

        } catch (Exception e) {
            System.err.println("OperatingSystemMXBean not available: " + e.getMessage());
        }
    }
}
