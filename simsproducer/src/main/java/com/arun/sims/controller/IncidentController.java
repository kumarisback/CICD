//package com.arun.sims.controller;
//
//import com.arun.sims.model.Incident;
//import com.arun.sims.service.IncidentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/incidents")
//public class IncidentController {
//
//    //    @Autowired
////    private ElasticSearchService elasticSearchService;
//    private final IncidentService service;
//
//    public IncidentController(IncidentService service) {
//        this.service = service;
//    }
//
//    @PostMapping
//    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
//        return ResponseEntity.ok(service.createIncident(incident));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Incident>> getAllIncidents() {
//        return ResponseEntity.ok(service.getAllIncidents());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
//        return ResponseEntity.ok(service.getIncidentById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Incident> updateIncident(@PathVariable Long id, @RequestBody Incident incident) {
//        return ResponseEntity.ok(service.updateIncident(id, incident));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
//        service.deleteIncident(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<Incident>> searchIncidents(@RequestParam String keyword) {
////        return ResponseEntity.ok(elasticSearchService.searchIncidents(keyword));
//        return  null;
//    }
//}
//
