package com.logonedigital.pi_mentorat_virtuel.service.Objectif;

import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ObjectifService {

    Objectif addObjectif(Objectif objectif);

    List<Objectif> getAllObjectif();

    //Page<PlanOrientation> getObjectifs(int offset, int pageSize);

    Objectif getObjectifById(Integer objectifid);

    Objectif updateObjectif(Objectif objectif, Integer objectifId);

    void deleteObjectifById(Integer id);




}
