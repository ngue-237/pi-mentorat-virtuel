package com.logonedigital.pi_mentorat_virtuel.services.Thematique;

import com.logonedigital.pi_mentorat_virtuel.entities.Thematique;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThematiqueServiceImp implements ThematiqueService{


    @Override
    public Thematique addThematique(Thematique thematique) {
        return null;
    }

    @Override
    public List<Thematique> getAllThematique() {
        return List.of();
    }

    @Override
    public Thematique getThematiqueById(Integer thematiqueId) {
        return null;
    }

    @Override
    public Thematique updateThematiqueById(Thematique thematique, Integer thematiqueId) {
        return null;
    }

    @Override
    public Thematique findThematiqueByLibelle(String libelle) {
        return null;
    }

    @Override
    public void deleteThematique(Integer thematiqueId) {

    }
}
