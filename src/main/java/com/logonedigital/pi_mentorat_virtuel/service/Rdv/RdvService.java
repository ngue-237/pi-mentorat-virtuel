package com.logonedigital.pi_mentorat_virtuel.service.Rdv;

import com.logonedigital.pi_mentorat_virtuel.entities.RDV;

import java.util.List;

public interface RdvService {
    public RDV addRdv(RDV rdv);
    List<RDV> getall();
    RDV getRDVById(Integer rdvId);
    RDV updateRDV(RDV rdv,Integer rdvId);
    void deleteRDV(Integer rdvId);
}
