package com.logonedigital.pi_mentorat_virtuel.repositories;



import com.logonedigital.pi_mentorat_virtuel.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    Optional<ImageEntity> findByFileName(String fileName);
}
