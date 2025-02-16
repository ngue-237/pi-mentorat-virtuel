package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceExistException;
import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.Mapper.CategorieMapper;
import com.logonedigital.pi_mentorat_virtuel.dto.CategorieReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.CategorieRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.repository.CategorieRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService{
    private final CategorieRepo categorieRepo;
    private final CategorieMapper categorieMapper;

    public CategorieServiceImpl(CategorieRepo categorieRepo, CategorieMapper categorieMapper) {
        this.categorieRepo = categorieRepo;
        this.categorieMapper = categorieMapper;
    }


    @Override
    public CategorieRespDTO addCategorie(CategorieReqDTO categorieReqDTO) {
        Categorie categorie = categorieMapper.toEntity(categorieReqDTO);

        Categorie addCategorie = categorieRepo.save(categorie);

        return categorieMapper.toDto(addCategorie);
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return this.categorieRepo.findAll();
    }

    @Override
    public Page<CategorieRespDTO> getsCategorie(int offset, int pageSize) {
        return this.categorieRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(Sort.Direction.DESC,"dateCreation")))
                .map(categorie -> this.categorieMapper.toDto(categorie));
    }

    @Override
    public CategorieRespDTO getCategorieById(Integer categorieId) {
        Categorie categorie = categorieRepo.findById(categorieId)
                .orElseThrow(()-> new ResourceNotFoundException("comment not found!!"));
        return categorieMapper.toDto(categorie);
    }


    @Override
    public Categorie updateCategorie(Categorie categrorie, Integer categorieId) {

        Optional<Categorie> categrorieToEdit = this.categorieRepo.findById(categorieId);
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
