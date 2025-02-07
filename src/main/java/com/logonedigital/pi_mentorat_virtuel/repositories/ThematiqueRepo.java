package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.Thematique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ThematiqueRepo extends JpaRepository<Thematique,Integer>{
    @Query("select t from Thematique t where t.libelle = :" +
            "libelle")
    Optional<Thematique> findThematiqueByLibelle(@Param("libelle") String libelle);
}
