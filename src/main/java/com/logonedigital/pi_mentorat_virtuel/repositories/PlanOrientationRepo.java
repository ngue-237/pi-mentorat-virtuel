package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlanOrientationRepo extends JpaRepository<PlanOrientation,Integer> {
    @Query("SELECT p from PlanOrientation p where p.suivi = :" +
            "suivi")
    Optional<PlanOrientation> findPlanOrientationBysuivi(@Param("suivi") String suivi);


}
