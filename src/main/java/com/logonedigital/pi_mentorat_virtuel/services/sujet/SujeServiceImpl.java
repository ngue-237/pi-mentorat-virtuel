package com.logonedigital.pi_mentorat_virtuel.services.sujet;

import com.github.slugify.Slugify;
import com.logonedigital.pi_mentorat_virtuel.entities.Suje;
import com.logonedigital.pi_mentorat_virtuel.exception.ResourceExistException;
import com.logonedigital.pi_mentorat_virtuel.exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.repositories.SujeRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SujeServiceImpl implements SujeService {
    private final SujeRepo sujeRepo;

    public SujeServiceImpl(SujeRepo sujeRepo) {
        this.sujeRepo = sujeRepo;
    }

    @Override
    public Suje add(Suje suje) {
        final Slugify slg = Slugify.builder().build();
        Optional<Suje> sujet1 = this.sujeRepo.findByTitle(suje.getTitle());
        if(sujet1.isPresent())
            throw new ResourceExistException("Sujet existe");
        suje.setSlug(slg.slugify(suje.getTitle()));
        suje.setContent(suje.getContent());
        suje.setCreatedAt(new Date());
        suje.setCreatedBy(suje.getCreatedBy());
        return this.sujeRepo.save(suje);
    }

    @Override
    public Page<Suje> getSujet(int offset, int pageSize) {
        return this.sujeRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(this.sujeRepo::save);
    }

    @Override
    public List<Suje> findByOrderByAsc() {
        List<Suje> sujes = sujeRepo.findByOrderByTitleAsc();
        if (sujes.isEmpty())
            throw new RuntimeException("Pas de sujet a trier");
        return sujes;
    }

    @Override
    public List<Suje> getAllSujet() {

        return this.sujeRepo.findAll();
    }

    @Override
    public Suje getById(Integer sujetId) {

        return this.sujeRepo.findById(sujetId).get();
    }

    @Override
    public Suje updated(Suje suje, Integer sujetId) {
        Optional<Suje> sujetToEdit = this.sujeRepo.findById(sujetId);
        if(sujetToEdit.isEmpty())
            throw new ResourceNotFoundException(" Le nom n'a pas ete trouve");
        if (suje.getTitle() != null){
            sujetToEdit.get().setTitle(suje.getTitle());
        }
        if (suje.getContent() != null){
            sujetToEdit.get().setContent(suje.getContent());
        }
        if (suje.getCreatedBy() != null)
            sujetToEdit.get().setCreatedBy(suje.getCreatedBy());
        return this.sujeRepo.saveAndFlush(sujetToEdit.get());

    }

    @Override
    public void delete(Integer sujetId) {
        this.sujeRepo.deleteById(sujetId);

    }
}
