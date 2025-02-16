package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.CategorieReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.CategorieRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categrorie;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class CategorieMapper {

    public Categrorie toEntity(CategorieReqDTO categorieReqDTO){
        Categrorie categrorie = new Categrorie();
        categrorie.setNom(categorieReqDTO.getNom());
        categrorie.setDescription(categorieReqDTO.getDescription());
        categrorie.setStatus(categorieReqDTO.getStatus());
        categrorie.setDateCreation(LocalDateTime.now());
        return categrorie;
    }

    public CategorieRespDTO toDto(Categrorie categrorie){
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
