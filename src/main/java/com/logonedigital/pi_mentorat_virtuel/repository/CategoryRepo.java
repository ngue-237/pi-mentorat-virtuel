package com.logonedigital.pi_mentorat_virtuel.repository;

import com.logonedigital.pi_mentorat_virtuel.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
