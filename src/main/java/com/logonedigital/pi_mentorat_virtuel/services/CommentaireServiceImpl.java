package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceExistException;
import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.repository.CommentaireRepo;
import com.sun.source.tree.OpensTree;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public Commentaire approveCommentaire(Integer commentaireId) {
        return null;
    }

    @Override
    public Commentaire reportInappropriateCommentaire(Integer commentaireId) {
        Optional<Commentaire> commentaireOptional = this.commentaireRepo.findById(commentaireId);
        if (commentaireOptional.isEmpty())
            throw new ResourceNotFoundException("comment not found!!");
        Commentaire commentaire = commentaireOptional.get();
        commentaire.setInappropriateReported(true);

        return commentaireRepo.save(commentaire);
    }

    @Override
    public List<Commentaire> getReportedComments() {
        return this.commentaireRepo.findByIsInappropriateReportedTrue();
    }

    @Override
    public List<Commentaire> getUnapprovedComments() {
        return null;
    }

    @Override
    public Commentaire getCommentaireById(Integer commentaireId) {

        return this.commentaireRepo.findById(commentaireId)
                .orElseThrow(()->new ResourceExistException("comment isn't present!!"));
    }

    @Override
    public Commentaire updateCommentaireById(Commentaire commentaire, Integer commentaireId) {

        Optional<Commentaire> commentaireToEdit = this.commentaireRepo.findById(commentaireId);
        if (commentaireToEdit.isEmpty())
            throw new ResourceNotFoundException("comment not found!!");

        if (commentaire.getContenu()!=null)
            commentaireToEdit.get().setContenu(commentaire.getContenu());
        if (commentaire.getStatus()!=null)
            commentaireToEdit.get().setStatus(commentaire.getStatus());
        commentaireToEdit.get().setDateModification(LocalDateTime.now());

        return this.commentaireRepo.saveAndFlush(commentaireToEdit.get());
    }

    @Override
    public void deleteCommentaireById(Integer commentaireId) {

        this.commentaireRepo.delete(this.commentaireRepo.findById(commentaireId)
                .orElseThrow(() -> new ResourceNotFoundException("comment not found!!")));
    }
}
