package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.PostReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.PostRespDTO;
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

        return postRespDTO;
    }
}
