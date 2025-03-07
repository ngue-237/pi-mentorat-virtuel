package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Integer> {

}
