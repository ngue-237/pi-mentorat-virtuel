package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepo extends JpaRepository<Commentaire, Integer> {
    List<Commentaire> findByIsInappropriateReportedTrue();  // Récupérer les commentaires signalés comme inappropriés

}
