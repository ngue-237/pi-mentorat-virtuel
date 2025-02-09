package com.logonedigital.pi_mentorat_virtuel.service.Rdv;

import com.logonedigital.pi_mentorat_virtuel.dto.RdvReqDto;
import com.logonedigital.pi_mentorat_virtuel.dto.RdvResDto;
import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import org.springframework.data.domain.Page;

public interface RdvService {
     RdvResDto addRdv(RdvReqDto rdvReqDto);
    Page<RdvResDto> getrdvs(int offset, int pageSize, RDV rdv);
    RDV getRDVById(Integer rdvId);
    RDV updateRDV(RDV rdv,Integer rdvId);
    void deleteRDV(Integer rdvId);
}
