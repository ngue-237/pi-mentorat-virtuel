package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.Mapper.CategorieMapper;
import com.logonedigital.pi_mentorat_virtuel.dto.CategorieReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.CategorieRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
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
        Categorie categrorie = categorieMapper.toEntity(categorieReqDTO);

        Categorie addCategorie = categorieRepo.save(categrorie);

        return categorieMapper.toDto(addCategorie);
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return this.categorieRepo.findAll();
    }

    @Override
    public Page<CategorieRespDTO> getsCategorie(int offset, int pageSize) {

        return this.categorieRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC,"dateCreation")))
                .map(categorie -> this.categorieMapper.toDto(categorie));
    }

    @Override
    public CategorieRespDTO getCategorieById(Integer categorieId) {

        Categorie categrorie = categorieRepo.findById(categorieId)
                .orElseThrow(()-> new ResourceNotFoundException("category not found!!"));
        return categorieMapper.toDto(categrorie);
    }
    @Override
    public Categorie updateCategorie(Categorie categorie, Integer categorieId) {

        Optional<Categorie> categorieToEdit = this.categorieRepo.findById(categorieId);
        if (categorieToEdit.isEmpty())

            throw new ResourceNotFoundException("category not found!!");
        if (categorie.getNom()!=null)
            categorieToEdit.get().setNom(categorie.getNom());
        if (categorie.getDescription()!=null)
            categorieToEdit.get().setDescription(categorie.getDescription());
        categorieToEdit.get().setDateModification(LocalDateTime.now());

        return this.categorieRepo.saveAndFlush(categorieToEdit.get());
    }

    @Override
    public void deleteCategorieById(Integer categorieId) {
        this.categorieRepo.delete(this.categorieRepo.findById(categorieId)
                .orElseThrow(()-> new ResourceNotFoundException("category not found!!")));
    }
}
