package com.logonedigital.pi_mentorat_virtuel.services.sujet;

import com.github.slugify.Slugify;
import com.logonedigital.pi_mentorat_virtuel.entities.Sujet;
import com.logonedigital.pi_mentorat_virtuel.exception.ResourceExisteException;
import com.logonedigital.pi_mentorat_virtuel.exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.repositories.SujetRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SujetServiceImpl implements SujetService{
    private final SujetRepo sujetRepo;

    public SujetServiceImpl(SujetRepo sujetRepo) {
        this.sujetRepo = sujetRepo;
    }

    @Override
    public Sujet add(Sujet sujet) {
        final Slugify slg = Slugify.builder().build();
        Optional<Sujet> sujet1 = this.sujetRepo.findByTitle(sujet.getTitle());
        if(sujet1.isPresent())
            throw new ResourceExisteException("Sujet existe");
        sujet.setSlug(slg.slugify(sujet.getTitle()));
        sujet.setContent(sujet.getContent());
        sujet.setCreatedAt(new Date());
        sujet.setCreatedBy(sujet.getCreatedBy());
        return this.sujetRepo.save(sujet);
    }

    @Override
    public Page<Sujet> getSujet(int offset, int pageSize) {
        return this.sujetRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(this.sujetRepo::save);
    }

    @Override
    public List<Sujet> findByOrderByAsc() {
        List<Sujet> sujets = sujetRepo.findByOrderByTitleAsc();
        if (sujets.isEmpty())
            throw new RuntimeException("Pas de sujet a trier");
        return sujets;
    }

    @Override
    public List<Sujet> getAllSujet() {

        return this.sujetRepo.findAll();
    }

    @Override
    public Sujet getById(Integer sujetId) {

        return this.sujetRepo.findById(sujetId).get();
    }

    @Override
    public Sujet updated(Sujet sujet, Integer sujetId) {
        Optional<Sujet> sujetToEdit = this.sujetRepo.findById(sujetId);
        if(sujetToEdit.isEmpty())
            throw new ResourceNotFoundException(" Le nom n'a pas ete trouve");
        if (sujet.getTitle() != null){
            sujetToEdit.get().setTitle(sujet.getTitle());
        }
        if (sujet.getContent() != null){
            sujetToEdit.get().setContent(sujet.getContent());
        }
        if (sujet.getCreatedBy() != null)
            sujetToEdit.get().setCreatedBy(sujet.getCreatedBy());
        return this.sujetRepo.saveAndFlush(sujetToEdit.get());

    }

    @Override
    public void delete(Integer sujetId) {
        this.sujetRepo.deleteById(sujetId);

    }
}
