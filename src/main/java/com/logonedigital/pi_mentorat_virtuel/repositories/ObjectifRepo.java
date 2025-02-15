package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectifRepo extends JpaRepository<Objectif,Integer> {
}
