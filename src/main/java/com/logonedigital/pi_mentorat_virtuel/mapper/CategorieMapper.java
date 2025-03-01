package com.logonedigital.pi_mentorat_virtuel.mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.Categorie.CategorieReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Categorie.CategorieRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class CategorieMapper {

    public Categorie toEntity(CategorieReqDTO categorieReqDTO){
        Categorie categrorie = new Categorie();
        categrorie.setNom(categorieReqDTO.getNom());
        categrorie.setDescription(categorieReqDTO.getDescription());
        categrorie.setStatus(categorieReqDTO.getStatus());
        categrorie.setDateCreation(LocalDateTime.now());
        return categrorie;
    }

    public CategorieRespDTO toDto(Categorie categrorie){
        CategorieRespDTO categorieRespDTO = new CategorieRespDTO();
        categorieRespDTO.setCategorieId(categrorie.getCategorieId());
        categorieRespDTO.setNom(categrorie.getNom());
        categorieRespDTO.setStatus(categrorie.getStatus());
        categorieRespDTO.setDescription(categrorie.getDescription());
        categorieRespDTO.setDateCreation(categrorie.getDateCreation());
        categorieRespDTO.setDateModification(LocalDateTime.now());
        return categorieRespDTO;
    }
}
