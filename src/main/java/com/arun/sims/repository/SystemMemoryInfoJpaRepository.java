package com.arun.sims.repository;

import com.arun.sims.model.SystemMemoryInfo ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemMemoryInfoJpaRepository extends JpaRepository<SystemMemoryInfo , Long> {
}