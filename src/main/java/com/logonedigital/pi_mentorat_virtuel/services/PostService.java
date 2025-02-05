package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.entities.Post;

import java.util.List;

public interface PostService {

    Post addPost(Post post);
    List<Post> getAllPost();
    Post getPostById(Integer postId);
    Post updatePostById(Post post,Integer postId);
    void deletePostById(Integer postId);

}
