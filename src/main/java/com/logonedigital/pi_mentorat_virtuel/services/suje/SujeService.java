package com.logonedigital.pi_mentorat_virtuel.services.suje;

import com.logonedigital.pi_mentorat_virtuel.entities.Suje;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SujeService {
    Suje add(Suje suje);
    Page<Suje> getSujet(int offset, int pageSize);
    List<Suje> findByOrderByAsc();
    List<Suje> getAllSujet();
    Suje getById(Integer sujetId);
    Suje updated(Suje suje, Integer sujetId);
    void delete(Integer sujetId);

}
