package com.arun.sims.service;

import com.arun.sims.model.Incident;
import com.arun.sims.repository.IncidentElasticsearchRepository;
import com.arun.sims.repository.IncidentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private ElasticSearchService elasticSearchService;

    private final IncidentJpaRepository repository;
    private final IncidentElasticsearchRepository incidentElasticsearchRepository;


    public IncidentService( @Qualifier("incidentJpaRepository") IncidentJpaRepository incidentJpaRepository,
                            @Qualifier("incidentElasticsearchRepository") IncidentElasticsearchRepository incidentElasticsearchRepository
    ) {
        this.repository = incidentJpaRepository;
        this.incidentElasticsearchRepository = incidentElasticsearchRepository;
    }

    public Incident createIncident(Incident incident) {
        Incident savedIncident = incidentElasticsearchRepository.save(incident);
        elasticSearchService.saveIncident(savedIncident);
        return repository.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return repository.findAll();
    }

    public Incident getIncidentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
    }

    public Incident updateIncident(Long id, Incident updatedIncident) {
        Incident incident = getIncidentById(id);
        incident.setTitle(updatedIncident.getTitle());
        incident.setSeverity(updatedIncident.getSeverity());
        incident.setStatus(updatedIncident.getStatus());
        incident.setAssignedTeam(updatedIncident.getAssignedTeam());
        return repository.save(incident);
    }

    public void deleteIncident(Long id) {
        repository.deleteById(id);
    }


}