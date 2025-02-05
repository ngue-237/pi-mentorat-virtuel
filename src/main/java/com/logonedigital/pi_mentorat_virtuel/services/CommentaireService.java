package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentaireService {

    Commentaire addCommentaire(Commentaire commentaire);
    List<Commentaire> getAllCommentaire();
    Commentaire approveCommentaire(Integer commentaireId);
    Commentaire reportInappropriateCommentaire(Integer commentaireId);
    public List<Commentaire> getReportedComments(); // Récupérer les commentaires signalés comme inappropriés
    public List<Commentaire> getUnapprovedComments();    // Récupérer les commentaires non approuvés
    Commentaire getCommentaireById(Integer commentaireId);
    Commentaire updateCommentaireById(Commentaire commentaire,Integer commentaireId);
    void deleteCommentaireById(Integer commentaireId);

}
