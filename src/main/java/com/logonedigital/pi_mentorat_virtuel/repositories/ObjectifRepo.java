package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ObjectifRepo extends JpaRepository<Objectif,Integer> {
    @Query("SELECT o from Objectif o where o.libelle = :" +
           "libelle")
    Optional<Objectif>findObjectifByLibelle(@Param("libelle") String libelle);


}
