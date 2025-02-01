package com.logonedigital.pi_mentorat_virtuel.Service.Ressource;

import com.logonedigital.pi_mentorat_virtuel.entities.Ressource;

import java.util.List;

public interface RessourceService {
    Ressource addRessource (Ressource ressource);
    List<Ressource> getAllRessourceById ();
    Ressource getRessourceByid (Long id);
    Ressource updateRessourceByid (Ressource ressource, Long id);
    void deleteRessourceByid(Long id);
}
