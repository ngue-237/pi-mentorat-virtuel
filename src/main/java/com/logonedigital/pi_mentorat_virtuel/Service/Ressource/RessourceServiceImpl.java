package com.logonedigital.pi_mentorat_virtuel.Service.Ressource;

import com.logonedigital.pi_mentorat_virtuel.entities.Category;
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
    public List<Ressource> getAllRessource() {

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
    public Ressource updateRessourceByid(Ressource ressource, Long id) {

        Optional<Ressource> ressourceOptional= this.ressourceRepo.findById(id);
        if (ressourceOptional.isEmpty())
            throw new RessourceNotFoundException("ressource not found");
        if (ressource.getDescription()!=null)
            ressourceOptional.get().setDescription(ressource.getDescription());
        if (ressource.getPrix()!=null)
            ressourceOptional.get().setPrix(ressource.getPrix());
        if (ressource.getEtat()!=null)
            ressourceOptional.get().setEtat(ressource.getEtat());
        if (ressource.getUpdateAt()!=null)
            ressourceOptional.get().setUpdateAt(ressource.getUpdateAt());
        if (ressource.getCreatAt()!=null)
            ressourceOptional.get().setCreatAt(ressource.getCreatAt());
        return ressourceOptional.get();
    }

    @Override
    public void deleteRessourceByid(Long id) {
        this.ressourceRepo.delete (this.ressourceRepo.findById(id)
                .orElseThrow(()->new RessourceNotFoundException("Ressource not found")));
    }

}