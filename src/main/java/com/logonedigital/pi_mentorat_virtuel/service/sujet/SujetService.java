package com.logonedigital.pi_mentorat_virtuel.service.sujet;

import com.logonedigital.pi_mentorat_virtuel.entities.Sujet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SujetService {
    Sujet add(Sujet sujet);
    Page<Sujet> getSujet(int offset, int pageSize);
    List<Sujet> findByOrderByAsc();
    List<Sujet> getAllSujet();
    Sujet getById(Integer sujetId);
    Sujet updated(Sujet sujet, Integer sujetId);
    void delete(Integer sujetId);

}
