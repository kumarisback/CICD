package com.arun.sims.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class JvmMemoryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long totalMemory;
    private long freeMemory;
    private long usedMemory;
    private long maxMemory;
    private LocalDateTime timestamp;

    public JvmMemoryInfo(long totalMemory, long freeMemory, long usedMemory, long maxMemory) {
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.usedMemory = usedMemory;
        this.maxMemory = maxMemory;
        this.timestamp=LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "JvmMemoryInfo{" +
                "totalMemory=" + totalMemory +
                ", freeMemory=" + freeMemory +
                ", usedMemory=" + usedMemory +
                ", maxMemory=" + maxMemory +
                ", timestamp=" + timestamp +
                '}';
    }
}