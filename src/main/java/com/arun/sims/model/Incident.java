//package com.arun.sims.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.data.elasticsearch.annotations.Document;
//
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//@Document(indexName = "incidents", createIndex = false)
//public class Incident {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;
//    private String severity; // e.g., Critical, Major, Minor
//    private String status;   // e.g., Open, Resolved
//    private String assignedTeam;
//    private LocalDateTime timestamp;
//
//    @PrePersist
//    public void onCreate() {
//        this.timestamp = LocalDateTime.now();
//    }
//}