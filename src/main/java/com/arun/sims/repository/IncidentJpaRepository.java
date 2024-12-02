package com.arun.sims.repository;

import com.arun.sims.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("incidentJpaRepository")
public interface IncidentJpaRepository extends JpaRepository<Incident, Long> {
}