package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.CommentaireReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.CommentaireRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.entities.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentaireMapper {


    public Commentaire toEntity(CommentaireReqDTO commentaireReqDTO){

        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(commentaireReqDTO.getContenu());
        commentaire.setStatus(commentaireReqDTO.getStatus());
        commentaire.setInappropriateReported(commentaireReqDTO.getInappropriateReported());
        commentaire.setDateCreation(LocalDateTime.now());

        if (commentaireReqDTO.getPostId()!=null){
            Post post = new Post();
            post.setPostId(commentaireReqDTO.getPostId());
            commentaire.setPost(post);

        }


        return commentaire;
    }

    public CommentaireRespDTO toDto(Commentaire commentaire){
        CommentaireRespDTO commentaireRespDTO = new CommentaireRespDTO();

        commentaireRespDTO.setCommentaireId(commentaire.getCommentaireId());
        commentaireRespDTO.setContenu(commentaire.getContenu());
        commentaireRespDTO.setStatus(commentaire.getStatus());
        commentaireRespDTO.setInappropriateReported(commentaire.getInappropriateReported());
        commentaireRespDTO.setDateCreation(commentaire.getDateCreation());
        commentaireRespDTO.setDateModification(LocalDateTime.now());

        if (commentaire.getPost()!=null){
            commentaireRespDTO.setPostId(commentaire.getPost().getPostId());
        }

        return commentaireRespDTO;
    }
}
