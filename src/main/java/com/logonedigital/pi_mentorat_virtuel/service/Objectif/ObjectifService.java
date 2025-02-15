package com.logonedigital.pi_mentorat_virtuel.service.Objectif;

import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;

import java.util.List;

public interface ObjectifService {

    Objectif addObjectif(Objectif objectif);

    void deleteObjectifById(int id);

    List<Objectif> getAllObjectif();

    Void deleteObjectif(int objectifId);

    Objectif getObjectifById(int id);

    Void deleteObjetif(int id);

    Objectif updateObjectif(Objectif objectif);

}
