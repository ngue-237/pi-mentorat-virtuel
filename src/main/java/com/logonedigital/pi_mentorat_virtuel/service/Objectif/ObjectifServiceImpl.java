package com.logonedigital.pi_mentorat_virtuel.service.Objectif;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import com.logonedigital.pi_mentorat_virtuel.repositories.ObjectifRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class  ObjectifServiceImpl implements ObjectifService {

    private final ObjectifRepo objectifRepo;

    public ObjectifServiceImpl(ObjectifRepo objectifRepo) {
        this.objectifRepo = objectifRepo;
    }

    @Override
    public Objectif addObjectif(Objectif objectif) {
        objectif.setCreatedAt(new Date());
        objectif.setStatus(true);
        return this.objectifRepo.saveAndFlush(objectif);
    }

    @Override
    public List<Objectif> getAllObjectif() {
        return this.objectifRepo.findAll();
    }

   // @Override
   // public Page<PlanOrientation> getObjectifs(int offset, int pageSize) {
   //     return null;
  //  }

    @Override
    public Objectif getObjectifById(Integer objectifid) {
        return this.objectifRepo.findById(objectifid).orElseThrow(
                ()-> new ResourceNotFoundException("Objectif not found!")
        );
    }

    @Override
    public Objectif updateObjectif(Objectif objectif, Integer objectifId) {
        Optional<Objectif> objectifToEdit = this.objectifRepo.findById(objectifId);
        if(objectifToEdit.isEmpty())
            throw new ResourceNotFoundException("Objectif not found!");
        if (objectif.getLibelle()!=null)
            objectifToEdit.get().setLibelle(objectif.getLibelle());
        if (objectif.getDescription()!=null)
            objectifToEdit.get().setDescription(objectif.getDescription());
        objectifToEdit.get().setUpdatedAt(new Date());
        if (objectif.getDomaine()!=null)
            objectifToEdit.get().setDomaine(objectif.getDomaine());
        objectifToEdit.get().setUpdatedAt(new Date());
        return this.objectifRepo.saveAndFlush(objectifToEdit.get());
    }

    @Override
    public void deleteObjectifById(Integer objectifid) {
        Objectif objectif = this.objectifRepo.findById(objectifid)
                .orElseThrow(()-> new ResourceNotFoundException("objectif not found!"));
        this.objectifRepo.delete(objectif);
    }
}
