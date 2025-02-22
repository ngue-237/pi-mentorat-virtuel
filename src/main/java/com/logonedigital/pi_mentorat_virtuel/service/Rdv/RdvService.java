package com.logonedigital.pi_mentorat_virtuel.service.Rdv;

import com.logonedigital.pi_mentorat_virtuel.dto.RdvReqDto;
import com.logonedigital.pi_mentorat_virtuel.dto.RdvResDto;
import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface RdvService {
     RdvResDto addRdv(RdvReqDto rdvReqDto);
    Page<RdvResDto> getrdvs(int offset, int pageSize, RDV rdv);

   // RDV searchrdv(String visioconference, Date debutdurdv, Date duree, String etat);
  RDV findRdvByVisioconference(String visioconference);
    RDV getRDVById(Integer rdvId);
    RDV updateRDV(RDV rdv,Integer rdvId);
    void deleteRDV(Integer rdvId);
}
