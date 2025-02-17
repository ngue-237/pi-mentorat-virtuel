package com.logonedigital.pi_mentorat_virtuel.service.Objectif;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.dto.ObjectifReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.ObjectifResDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import com.logonedigital.pi_mentorat_virtuel.mapper.ObjectifMapper;
import com.logonedigital.pi_mentorat_virtuel.repositories.ObjectifRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class  ObjectifServiceImpl implements ObjectifService {

    private final ObjectifRepo objectifRepo;
    private final ObjectifMapper objectifMapper;

    public ObjectifServiceImpl(ObjectifRepo objectifRepo, ObjectifMapper objectifMapper) {
        this.objectifRepo = objectifRepo;
        this.objectifMapper = objectifMapper;
    }

    @Override
    public ObjectifResDTO addObjectif(ObjectifReqDTO objectifReqDTO) {
        Objectif objectif = this.objectifMapper.fromObjectifReqDTO(objectifReqDTO);
        objectif.setCreatedAt(new Date());
        objectif.setStatus(true);
        return this.objectifMapper.fromObjectif(this.objectifRepo.saveAndFlush(objectif));
    }

    @Override
    public List<Objectif> getAllObjectif() {
        return this.objectifRepo.findAll();
    }

    @Override
    public Page<ObjectifResDTO> getObjectifs(int offset, int pageSize) {
        return this.objectifRepo.findAll(PageRequest.of(offset,pageSize, Sort.by(Sort.Direction.DESC,"createdAt")))
                .map(this.objectifMapper::fromObjectif);
    }

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

   @Override
    public Objectif getObjectifByLibelle(String libelle) {

    return  this.objectifRepo.findObjectifByLibelle(libelle)
                .orElseThrow(()->new ResourceNotFoundException("objectif not found"));
    }
}
