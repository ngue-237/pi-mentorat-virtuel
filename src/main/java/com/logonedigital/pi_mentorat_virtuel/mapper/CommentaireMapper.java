
package com.logonedigital.pi_mentorat_virtuel.mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.CommentaireReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.CommentaireRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentaireMapper {


    public Commentaire toEntity(CommentaireReqDTO commentaireReqDTO){

        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(commentaireReqDTO.getContenu());
        commentaire.setStatus(commentaireReqDTO.getStatus());
        commentaire.setDateCreation(LocalDateTime.now());

        return commentaire;
    }

    public CommentaireRespDTO toDto(Commentaire commentaire){
        CommentaireRespDTO commentaireRespDTO = new CommentaireRespDTO();

        commentaireRespDTO.setCommentaireId(commentaire.getCommentaireId());
        commentaireRespDTO.setContenu(commentaire.getContenu());
        commentaireRespDTO.setStatus(commentaire.getStatus());
        commentaireRespDTO.setDateCreation(commentaire.getDateCreation());
        commentaireRespDTO.setDateModification(LocalDateTime.now());

        return commentaireRespDTO;
    }
}
