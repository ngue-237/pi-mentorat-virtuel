package com.logonedigital.pi_mentorat_virtuel.services.Thematique;

import com.logonedigital.pi_mentorat_virtuel.entities.Thematique;

import java.util.List;

public interface ThematiqueService {
    Thematique addThematique(Thematique thematique);
    List<Thematique> getAllThematique();
    Thematique getThematiqueById(Integer thematiqueId);
    Thematique updateThematiqueById(Thematique thematique, Integer thematiqueId);
    Thematique findThematiqueByLibelle(String libelle);
    void deleteThematique(Integer thematiqueId);
}
