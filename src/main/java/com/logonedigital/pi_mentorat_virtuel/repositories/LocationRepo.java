package com.logonedigital.pi_mentorat_virtuel.repositories;


import com.logonedigital.pi_mentorat_virtuel.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {

}
