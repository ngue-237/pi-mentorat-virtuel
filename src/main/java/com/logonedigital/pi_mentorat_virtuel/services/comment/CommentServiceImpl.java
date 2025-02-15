package com.logonedigital.pi_mentorat_virtuel.services.comment;

import com.logonedigital.pi_mentorat_virtuel.entities.Comment;
import com.logonedigital.pi_mentorat_virtuel.repositories.CommentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;


    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment add(Comment comment) {
        comment.setContent(comment.getContent());
        comment.setCreatedBy(comment.getCreatedBy());
        comment.setCreatedAt(new Date());
        //Commentaire commentaire = this.commentaireMapper.fromCommentaireReqDTO(commentaireReqDTO);
        comment.setCreatedAt(new Date());
        return this.commentRepo.save(comment);
    }

    @Override
    public Page<Comment> getComment(int offset, int pageSize) {
        return this.commentRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(this.commentRepo::save);
    }

    @Override
    public List<Comment> getAllcom() {
        return this.commentRepo.findAll();
    }


    @Override
    public Comment getById(Integer commentaireId) {
        return this.commentRepo.findById(commentaireId).get();
    }

    @Override
    public Comment updated(Comment comment, Integer commentaireId) {
        Comment comment1 = this.commentRepo.findById(commentaireId).get();
        if(comment.getContent() != null) {
            comment1.setContent(comment.getContent());
        }
        if(comment.getCreatedBy() != null) {
            comment1.setCreatedBy(comment.getCreatedBy());
        }
        comment1.setUpdatedAt(new Date());

        return this.commentRepo.saveAndFlush(comment1);
    }

    @Override
    public void delete(Integer commentaireId) {
        this.commentRepo.deleteById(commentaireId);
    }

}