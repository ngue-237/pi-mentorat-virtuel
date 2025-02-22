package com.logonedigital.pi_mentorat_virtuel.services.comment;

import com.logonedigital.pi_mentorat_virtuel.entities.Comment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
    Comment add(Comment comment);
    Page<Comment> getComment(int offset, int pageSize);
    List<Comment> getAllcom();
    Comment getById(Integer commentaireId);
    Comment updated(Comment comment, Integer commentaireId);
    void delete(Integer commentaireId);

}