package com.logonedigital.pi_mentorat_virtuel.Service.Ressource;

import com.logonedigital.pi_mentorat_virtuel.exception.RessourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.Ressource;
import com.logonedigital.pi_mentorat_virtuel.repository.RessourceRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class RessourceServiceImpl implements RessourceService{
    private final RessourceRepo ressourceRepo;

    public RessourceServiceImpl(RessourceRepo ressourceRepo) {
        this.ressourceRepo = ressourceRepo;
    }


    @Override
    public Ressource addRessource(Ressource ressource) {

        ressource.setEtat(ressource.getEtat());
        ressource.setPrix(ressource.getPrix());
        ressource.setDescription(ressource.getDescription());
        ressource.setCreatAt(new Date());
        return this.ressourceRepo.save(ressource);
    }

    @Override
    public List<Ressource> getAllRessourceById() {

        return this.ressourceRepo.findAll();
    }

    @Override
    public Ressource getRessourceByid(Long id) {
        Optional<Ressource> ressource = this.ressourceRepo.findById(id);
        if (ressource.isEmpty())
            throw new RessourceNotFoundException("Ressource not found");
        return ressource.get();
    }

    @Override
    public Ressource updateRessourceByid(Ressource newRessource, Long id) {

        Optional<Ressource> oldRessource = this.ressourceRepo.findById(id);
        if (oldRessource.isEmpty())
            throw new RessourceNotFoundException("Ressource Not Found");
        return newRessource;
    }

    @Override
    public void deleteRessourceByid(Long id) {

    }
}