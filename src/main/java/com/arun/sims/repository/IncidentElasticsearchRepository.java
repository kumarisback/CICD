package com.arun.sims.repository;

import com.arun.sims.model.Incident;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("incidentElasticsearchRepository")
public interface IncidentElasticsearchRepository extends ElasticsearchRepository<Incident, String> {
    List<Incident> findByTitleContaining(String title);
}