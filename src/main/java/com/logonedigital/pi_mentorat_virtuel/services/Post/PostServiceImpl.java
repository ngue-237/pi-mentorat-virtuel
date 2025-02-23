package com.logonedigital.pi_mentorat_virtuel.services.Post;

import com.logonedigital.pi_mentorat_virtuel.exception.ResourceExistException;
import com.logonedigital.pi_mentorat_virtuel.exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.Mapper.PostMapper;
import com.logonedigital.pi_mentorat_virtuel.dto.Post.PostReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Post.PostRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Post;
import com.logonedigital.pi_mentorat_virtuel.repositories.PostRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final PostMapper postMapper;

    public PostServiceImpl(PostRepo postRepo, PostMapper postMapper) {
        this.postRepo = postRepo;
        this.postMapper = postMapper;
    }


    @Override
    public PostRespDTO addPost(PostReqDTO postReqDTO) {

        Post post = postMapper.toEntity(postReqDTO);

        Post addPost = postRepo.save(post);

        return postMapper.toDto(addPost);
    }

    @Override
    public List<Post> getAllPost() {
        return this.postRepo.findAll();
    }

    @Override
    public Post getPostByNom(String nom) {

        Optional<Post> post = this.postRepo.findPostByNom(nom);
        if (post.isEmpty())
            throw new ResourceNotFoundException("le post avec ce nom n'existe!!");
        return post.get();
    }

    @Override
    public Page<Post> getsPost(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return this.postRepo.findAll(pageable);
    }

    @Override
    public Post getPostById(Integer postId) {
        return this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceExistException("post isn't exist!!"));
    }

    @Override
    public Post updatePostById(Post post, Integer postId) {
        //recherche
        Optional<Post> postToEdit = this.postRepo.findById(postId);
        if (postToEdit.isEmpty())
            throw new ResourceNotFoundException("post not found!");
        if (post.getNom()!=null)
            postToEdit.get().setNom(post.getNom());
       if (post.getContenu()!=null)
            postToEdit.get().setContenu(post.getContenu());
        postToEdit.get().setDateModification(LocalDateTime.now());

        return this.postRepo.saveAndFlush(postToEdit.get());
    }

    @Override
    public void deletePostById(Integer postId) {
        this.postRepo.delete(this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("post not found!!")));
    }
}
