package com.logonedigital.pi_mentorat_virtuel.services.Commentaire;

import com.logonedigital.pi_mentorat_virtuel.exception.ResourceExistException;
import com.logonedigital.pi_mentorat_virtuel.exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.mapper.CommentaireMapper;
import com.logonedigital.pi_mentorat_virtuel.dto.Commentaire.CommentaireReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Commentaire.CommentaireRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.repositories.CommentaireRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl implements CommentaireService {
    private final CommentaireRepo commentaireRepo;
    private final CommentaireMapper commentaireMapper;

    public CommentaireServiceImpl(CommentaireRepo commentaireRepo, CommentaireMapper commentaireMapper) {
        this.commentaireRepo = commentaireRepo;
        this.commentaireMapper = commentaireMapper;
    }


    @Override
    public CommentaireRespDTO addCommentaire(CommentaireReqDTO commentaireReqDTO) {
        Commentaire commentaire = commentaireMapper.toEntity(commentaireReqDTO);

        Commentaire addCommentaire = commentaireRepo.save(commentaire);

        return commentaireMapper.toDto(addCommentaire);
    }

    @Override
    public List<Commentaire> getAllCommentaire() {

        return this.commentaireRepo.findAll();
    }

    @Override
    public Page<Commentaire> getsCommentaire(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return this.commentaireRepo.findAll(pageable);
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
