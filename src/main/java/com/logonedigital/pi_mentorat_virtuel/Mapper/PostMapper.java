package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.PostReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.PostRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.entities.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostMapper {

    public Post toEntity(PostReqDTO postReqDTO){
        Post post = new Post();
        post.setNom(postReqDTO.getNom());
        post.setContenu(postReqDTO.getContenu());
        post.setStatus(postReqDTO.getStatus());
        post.setDateCreation(LocalDateTime.now());

        if (postReqDTO.getCategorieId()!=null){
            Categorie categorie = new Categorie();
            categorie.setCategorieId(postReqDTO.getCategorieId());
            post.setCategorie(categorie);
        }
       /* if (postReqDTO.getCommentaireId()!=null){
            Commentaire commentaire = new Commentaire();
            commentaire.setCommentaireId(postReqDTO.getCommentaireId());
            post.setCommentaire(commentaire);
        }*/

        return post;
    }

    public PostRespDTO toDto(Post post){
        PostRespDTO postRespDTO = new PostRespDTO();

        postRespDTO.setPostId(post.getPostId());
        postRespDTO.setNom(post.getNom());
        postRespDTO.setContenu(post.getContenu());
        postRespDTO.setStatus(post.getStatus());
        postRespDTO.setDateCreation(post.getDateCreation());
        postRespDTO.setDateModification(LocalDateTime.now());

        if (post.getCategorie()!=null){
            postRespDTO.setCategorieId(post.getCategorie().getCategorieId());
        }

       /* if (post.getCommentaire()!=null){
            postRespDTO.setCommentaireId(post.getCommentaire().getCommentaireId());
        }*/

        return postRespDTO;
    }
}
