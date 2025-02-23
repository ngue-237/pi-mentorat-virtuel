package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.PostReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.PostRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
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
            post.setCategorie(categorie);}

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
            postRespDTO.setCategorieId(post.getCategorie().getCategorieId());}

        return postRespDTO;
    }
}
