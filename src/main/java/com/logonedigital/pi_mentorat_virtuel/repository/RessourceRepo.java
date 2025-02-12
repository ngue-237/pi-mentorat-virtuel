package com.logonedigital.pi_mentorat_virtuel.repository;

import com.logonedigital.pi_mentorat_virtuel.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepo extends JpaRepository<Ressource, Long> {
}
