package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.dto.CategorieReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.CategorieRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categrorie;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    CategorieRespDTO addCategorie(CategorieReqDTO categorieReqDTO);
    List<Categrorie> getAllCategorie();
    Page<Categrorie> getsPost(int page,int size);
    Categrorie getCategorieById(Integer categorieId);
    Categrorie updateCategorie(Categrorie categrorie,Integer categorieId);
    void deleteCategorieById(Integer categorieId);
}
