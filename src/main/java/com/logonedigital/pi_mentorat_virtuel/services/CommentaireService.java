package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.dto.CommentaireReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.CommentaireRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentaireService {

    CommentaireRespDTO addCommentaire(CommentaireReqDTO commentaireReqDTO);
    List<Commentaire> getAllCommentaire();
    Page<CommentaireRespDTO> getsCommentaire(int offset,int pageSize);
    List<Commentaire> getReportedComments(); // Récupérer les commentaires signalés comme inappropriés
    CommentaireRespDTO getCommentaireById(Integer commentaireId);
    Commentaire updateCommentaireById(Commentaire commentaire,Integer commentaireId);
    void deleteCommentaireById(Integer commentaireId);

}
