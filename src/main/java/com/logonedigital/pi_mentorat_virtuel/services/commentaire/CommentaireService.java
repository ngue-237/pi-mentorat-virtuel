package com.logonedigital.pi_mentorat_virtuel.services.commentaire;

import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentaireService {
    Commentaire add(Commentaire commentaire);
    Page<Commentaire> getComment(int offset, int pageSize);
    List<Commentaire> getAllcom();
    Commentaire getById(Integer commentaireId);
    Commentaire updated(Commentaire commentaire, Integer commentaireId);
    void delete(Integer commentaireId);

}