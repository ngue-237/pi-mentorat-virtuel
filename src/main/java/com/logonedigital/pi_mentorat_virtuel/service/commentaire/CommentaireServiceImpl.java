package com.logonedigital.pi_mentorat_virtuel.service.commentaire;

import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.repositories.CommentaireRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CommentaireServiceImpl implements CommentaireService {
    private final CommentaireRepo commentaireRepo;


    public CommentaireServiceImpl(CommentaireRepo commentaireRepo) {
        this.commentaireRepo = commentaireRepo;
    }

    @Override
    public Commentaire add(Commentaire commentaire) {
        commentaire.setContent(commentaire.getContent());
        commentaire.setCreatedBy(commentaire.getCreatedBy());
        commentaire.setCreatedAt(new Date());
        //Commentaire commentaire = this.commentaireMapper.fromCommentaireReqDTO(commentaireReqDTO);
        commentaire.setCreatedAt(new Date());
        return this.commentaireRepo.save(commentaire);
    }

    @Override
    public Page<Commentaire> getComment(int offset, int pageSize) {
        return this.commentaireRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(this.commentaireRepo::save);
    }

    @Override
    public List<Commentaire> getAllcom() {
        return this.commentaireRepo.findAll();
    }


    @Override
    public Commentaire getById(Integer commentaireId) {
        return this.commentaireRepo.findById(commentaireId).get();
    }

    @Override
    public Commentaire updated(Commentaire commentaire, Integer commentaireId) {
        Commentaire commentaire1 = this.commentaireRepo.findById(commentaireId).get();
        if(commentaire.getContent() != null) {
            commentaire1.setContent(commentaire.getContent());
        }
        if(commentaire.getCreatedBy() != null) {
            commentaire1.setCreatedBy(commentaire.getCreatedBy());
        }
        commentaire1.setUpdatedAt(new Date());

        return this.commentaireRepo.saveAndFlush(commentaire1);
    }

    @Override
    public void delete(Integer commentaireId) {
        this.commentaireRepo.deleteById(commentaireId);
    }

}