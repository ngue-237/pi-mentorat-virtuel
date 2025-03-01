package com.logonedigital.pi_mentorat_virtuel.services.Commentaire;

import com.logonedigital.pi_mentorat_virtuel.dto.Commentaire.CommentaireReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Commentaire.CommentaireRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentaireService {

    CommentaireRespDTO addCommentaire(CommentaireReqDTO commentaireReqDTO);
    List<Commentaire> getAllCommentaire();
    Page<Commentaire> getsCommentaire(int pageNumber,int pageSize);
    Commentaire reportInappropriateCommentaire(Integer commentaireId);
    List<Commentaire> getReportedComments(); // Récupérer les commentaires signalés comme inappropriés
    Commentaire getCommentaireById(Integer commentaireId);
    Commentaire updateCommentaireById(Commentaire commentaire,Integer commentaireId);
    void deleteCommentaireById(Integer commentaireId);

}
