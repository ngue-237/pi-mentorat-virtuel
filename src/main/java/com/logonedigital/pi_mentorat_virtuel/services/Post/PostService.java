package com.logonedigital.pi_mentorat_virtuel.services.Post;

import com.logonedigital.pi_mentorat_virtuel.dto.Post.PostReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Post.PostRespDTO;
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
