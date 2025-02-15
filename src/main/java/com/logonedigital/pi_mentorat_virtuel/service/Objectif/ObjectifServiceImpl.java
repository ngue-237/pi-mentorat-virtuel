package com.logonedigital.pi_mentorat_virtuel.service.Objectif;

import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import com.logonedigital.pi_mentorat_virtuel.repositories.ObjectifRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class  ObjectifServiceImpl implements ObjectifService {

    private final ObjectifRepo objectifRepo;

    public ObjectifServiceImpl(ObjectifRepo objectifRepo) {
        this.objectifRepo = objectifRepo;
    }


    @Override
    public Objectif addObjectif(Objectif objectif) {

        return objectifRepo.save(objectif);
    }


    public List<Objectif> getAllObjectifs() {
        return objectifRepo.findAll();
    }

    @Override
    public Objectif getObjectifById(int objectifId) {
        return objectifRepo.findById(objectifId).get();
    }

    @Override
    public Void deleteObjetif(int objectifId) {
        objectifRepo.deleteById(objectifId);
        return null;
    }

    @Override
    public void deleteObjectifById(int id) {

        objectifRepo
                .findById(id)
                .ifPresentOrElse(objectifRepo::delete,()->{
                            throw new
                                    EntityNotFoundException("Objectif not found");
                        }
                );

    }


    @Override
    public List<Objectif> getAllObjectif() {
        List<Objectif> objectifs=objectifRepo.findAll();

        return objectifs;
    }

    @Override
    public Objectif updateObjectif(Objectif objectif){

        return objectifRepo.save(objectif);
    }




    @Override
    public Void deleteObjectif(int objectifId) {
        objectifRepo.deleteById(objectifId);
        return null;
    }
    public Page<Objectif> getObjectifs(Pageable pageable){
        return objectifRepo.findAll(pageable);
    }
}
