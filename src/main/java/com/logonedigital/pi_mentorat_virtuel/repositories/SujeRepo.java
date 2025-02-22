package com.logonedigital.pi_mentorat_virtuel.repositories;


import com.logonedigital.pi_mentorat_virtuel.entities.Suje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SujeRepo extends JpaRepository<Suje, Integer> {
    Optional<Suje> findByTitle(String title);

    List<Suje> findByOrderByTitleAsc();

}