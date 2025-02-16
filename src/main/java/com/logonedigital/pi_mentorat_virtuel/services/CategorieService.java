package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.dto.CategorieReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.CategorieRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategorieService {
    CategorieRespDTO addCategorie(CategorieReqDTO categorieReqDTO);
    List<Categorie> getAllCategorie();
    Page<CategorieRespDTO> getsCategorie(int offset,int pageSize);
    CategorieRespDTO getCategorieById(Integer categorieId);
    Categorie updateCategorie(Categorie categorie, Integer categorieId);
    void deleteCategorieById(Integer categorieId);
}