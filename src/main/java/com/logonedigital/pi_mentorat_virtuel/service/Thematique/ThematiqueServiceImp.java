package com.logonedigital.pi_mentorat_virtuel.service.Thematique;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.Thematique;
import com.logonedigital.pi_mentorat_virtuel.repositories.ThematiqueRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ThematiqueServiceImp implements ThematiqueService{

private final ThematiqueRepo thematiqueRepo;

    public ThematiqueServiceImp(ThematiqueRepo thematiqueRepo) {
        this.thematiqueRepo = thematiqueRepo;
    }

    @Override
    public Thematique addThematique(Thematique thematique) {

        return this.thematiqueRepo.save(thematique);
    }

    @Override
    public List<Thematique> getAllThematique() {

        return this.thematiqueRepo.findAll();
    }

    @Override
    public Thematique getThematiqueById(Integer thematiqueId) {

        return this.thematiqueRepo.findById(thematiqueId).orElseThrow(() -> new ResourceNotFoundException("Thematique with ID not found" ));
    }

    @Override
    public Thematique updateThematiqueById(Thematique thematique, Integer thematiqueId) {
        Optional<Thematique> thematiqueToEdit = this.thematiqueRepo.findById(thematiqueId);
        if(thematiqueToEdit.isEmpty())
            throw new ResourceNotFoundException("Thematique not found !");
        if(thematique.getLibelle()!=null)
            thematiqueToEdit.get().setLibelle(thematique.getLibelle());

        return this.thematiqueRepo.saveAndFlush(thematiqueToEdit.get());

    }

    @Override
    public Thematique findThematiqueByLibelle(String libelle) {

        Optional<Thematique> thematique = this.thematiqueRepo.findThematiqueByLibelle(libelle);
        if (thematique.isEmpty())
            throw new ResourceNotFoundException("feedback not found");
        return thematique.get();
    }

    @Override
    public void deleteThematique(Integer thematiqueId) {
        this.thematiqueRepo.deleteById(thematiqueId);

    }
}
