package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentaireService {

    Commentaire addCommentaire(Commentaire commentaire);
    List<Commentaire> getAllCommentaire();
    Commentaire getCommentaireById(Integer commentaireId);
    Commentaire updateCommentaire(Commentaire commentaire,Integer commentaireId);
    void deleteCommentaireById(Integer commentaireId);

}
