package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}

