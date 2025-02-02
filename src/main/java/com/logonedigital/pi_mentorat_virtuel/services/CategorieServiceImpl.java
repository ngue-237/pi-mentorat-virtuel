package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.entities.Categrorie;
import com.logonedigital.pi_mentorat_virtuel.repository.CategorieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService{
    private final CategorieRepo categorieRepo;

    public CategorieServiceImpl(CategorieRepo categorieRepo) {
        this.categorieRepo = categorieRepo;
    }

    @Override
    public Categrorie addCategorie(Categrorie categrorie) {
        return this.categorieRepo.save(categrorie);
    }

    @Override
    public List<Categrorie> getAllCategorie() {
        return this.categorieRepo.findAll();
    }

    @Override
    public Optional<Categrorie> getCategorieById(Integer categorieId) {
        return this.categorieRepo.findById(categorieId);


    }

    @Override
    public Categrorie updateCategorie(Categrorie categrorie, Integer categorieId) {
        return null;
    }

    @Override
    public void deleteCategorieById(Integer categorieId) {

        this.categorieRepo.deleteById(categorieId);
    }
}
