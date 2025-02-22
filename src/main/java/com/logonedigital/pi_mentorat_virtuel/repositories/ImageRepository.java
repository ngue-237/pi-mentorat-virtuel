package com.logonedigital.pi_mentorat_virtuel.repositories;



import com.logonedigital.pi_mentorat_virtuel.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    Optional<ImageEntity> findByFileName(String fileName);
}
