package com.logonedigital.pi_mentorat_virtuel.repository;

import com.logonedigital.pi_mentorat_virtuel.entities.Competency;
import com.logonedigital.pi_mentorat_virtuel.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetencyRepo extends JpaRepository<Competency, Integer> {

}
