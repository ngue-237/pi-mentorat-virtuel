package com.logonedigital.pi_mentorat_virtuel.repositories;


import com.logonedigital.pi_mentorat_virtuel.entities.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SujetRepo extends JpaRepository<Sujet, Integer> {
    Optional<Sujet> findByTitle(String title);

    List<Sujet> findByOrderByTitleAsc();

}