package com.arun.sims.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Data
@Entity
public class SystemMemoryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long totalPhysicalMemory;
    private long freePhysicalMemory;
    private long usedPhysicalMemory;

    private LocalDateTime timestamp;

    public SystemMemoryInfo(long totalPhysicalMemory, long freePhysicalMemory, long usedPhysicalMemory) {
        this.totalPhysicalMemory = totalPhysicalMemory;
        this.freePhysicalMemory = freePhysicalMemory;
        this.usedPhysicalMemory = usedPhysicalMemory;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "SystemMemoryInfo{" +
                "totalPhysicalMemory=" + totalPhysicalMemory +
                ", freePhysicalMemory=" + freePhysicalMemory +
                ", usedPhysicalMemory=" + usedPhysicalMemory +
                ", timeStamp=" + timestamp +
                '}';
    }
}