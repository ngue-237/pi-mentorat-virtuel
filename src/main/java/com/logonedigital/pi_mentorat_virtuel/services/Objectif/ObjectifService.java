package com.logonedigital.pi_mentorat_virtuel.services.Objectif;

import com.logonedigital.pi_mentorat_virtuel.dto.Objectif.ObjectifReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Objectif.ObjectifResDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ObjectifService {

    ObjectifResDTO addObjectif(ObjectifReqDTO objectifReqDTO);

    List<Objectif> getAllObjectif();

    Page<ObjectifResDTO> getObjectifs(int offset, int pageSize);

    Objectif getObjectifById(Integer objectifid);

    Objectif updateObjectif(Objectif objectif, Integer objectifId);

    void deleteObjectifById(Integer id);


  Objectif getObjectifByLibelle(String libelle);
}

