package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceExistException;
import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.Categrorie;
import com.logonedigital.pi_mentorat_virtuel.repository.CategorieRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Page<Categrorie> getsPost(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.categorieRepo.findAll(pageable);
    }

    @Override
    public Categrorie getCategorieById(Integer categorieId) {
      return this.categorieRepo.findById(categorieId).
              orElseThrow(()->new ResourceExistException("category isn't exist!!"));
    }
    @Override
    public Categrorie updateCategorie(Categrorie categrorie, Integer categorieId) {

        Optional<Categrorie> categrorieToEdit = this.categorieRepo.findById(categorieId);
        if (categrorieToEdit.isEmpty())

            throw new ResourceNotFoundException("category not found!!");
        if (categrorie.getNom()!=null)
            categrorieToEdit.get().setNom(categrorie.getNom());
        if (categrorie.getDescription()!=null)
            categrorieToEdit.get().setDescription(categrorie.getDescription());
        categrorieToEdit.get().setDateModification(LocalDateTime.now());

        return this.categorieRepo.saveAndFlush(categrorieToEdit.get());
    }

    @Override
    public void deleteCategorieById(Integer categorieId) {
        this.categorieRepo.delete(this.categorieRepo.findById(categorieId)
                .orElseThrow(()-> new ResourceNotFoundException("category not found!!")));
    }
}
