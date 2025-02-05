package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.repository.CommentaireRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService{
    private final CommentaireRepo commentaireRepo;

    public CommentaireServiceImpl(CommentaireRepo commentaireRepo) {
        this.commentaireRepo = commentaireRepo;
    }

    @Override
    public Commentaire addCommentaire(Commentaire commentaire) {
        return this.commentaireRepo.save(commentaire);
    }

    @Override
    public List<Commentaire> getAllCommentaire() {

        return this.commentaireRepo.findAll();
    }

    @Override
    public Commentaire getCommentaireById(Integer commentaireId) {
        return null;
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire, Integer commentaireId) {
        return null;
    }

    @Override
    public void deleteCommentaireById(Integer commentaireId) {

        this.commentaireRepo.delete(this.commentaireRepo.findById(commentaireId)
                .orElseThrow(() -> new ResourceNotFoundException("comment not found!!")));
    }
}
