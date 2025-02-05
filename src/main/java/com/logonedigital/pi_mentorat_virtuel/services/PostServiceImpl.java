package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.entities.Post;
import com.logonedigital.pi_mentorat_virtuel.repository.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post addPost(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return this.postRepo.findAll();
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public Post updatePostById(Post post, Integer postId) {
        return null;
    }

    @Override
    public void deletePostById(Integer postId) {

        
    }
}
