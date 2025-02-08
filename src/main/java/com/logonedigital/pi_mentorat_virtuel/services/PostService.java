package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.dto.PostReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.PostRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    PostRespDTO addPost(PostReqDTO postReqDTO);
    List<Post> getAllPost();
    Post getPostByNom(String nom);
    Page<Post> getsPost(int pageNumber,int pageSize);
    Post getPostById(Integer postId);
    Post updatePostById(Post post,Integer postId);
    void deletePostById(Integer postId);

}
