package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.entities.Categrorie;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    Categrorie addCategorie(Categrorie categrorie);
    List<Categrorie> getAllCategorie();
    Optional<Categrorie> getCategorieById(Integer categorieId);
    Categrorie updateCategorie(Categrorie categrorie,Integer categorieId);
    void deleteCategorieById(Integer categorieId);
}
