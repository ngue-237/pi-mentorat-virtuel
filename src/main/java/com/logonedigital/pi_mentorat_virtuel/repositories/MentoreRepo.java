package com.logonedigital.pi_mentorat_virtuel.repositories;


import com.logonedigital.pi_mentorat_virtuel.entities.Mentore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentoreRepo extends JpaRepository<Mentore, Integer> {

    Optional<Mentore> findByEmail(String email);

    @Query("select m from Mentore m where m.email = :email")
    Optional<Mentore> fetchByEmail(@Param("email") String email);
}
