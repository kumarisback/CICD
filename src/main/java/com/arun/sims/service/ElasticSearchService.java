//package com.arun.sims.service;
//
//import com.arun.sims.model.Incident;
//import com.arun.sims.repository.IncidentElasticsearchRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ElasticSearchService {
//    private final IncidentElasticsearchRepository repository;
//
//    public ElasticSearchService(IncidentElasticsearchRepository repository) {
//        this.repository = repository;
//    }
//
//    public Incident saveIncident(Incident incident) {
//        return repository.save(incident);
//    }
//
//    public List<Incident> searchIncidents(String keyword) {
//        return repository.findByTitleContaining(keyword);
//    }
//
//}
