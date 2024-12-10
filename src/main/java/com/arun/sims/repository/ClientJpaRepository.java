package com.arun.sims.repository;

import com.arun.sims.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<Client, Long> {
    Client getClientByPhoneNumber(String phoneNumber);
}