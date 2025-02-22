package com.logonedigital.pi_mentorat_virtuel.services.Mentore;

import com.logonedigital.pi_mentorat_virtuel.dto.Mentore.MentoreReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Mentore.MentoreRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Mentore;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MentoreService {

    MentoreRespDTO addMentore(@Valid MentoreReqDTO mentoreReqDTO);
    List<Mentore> getMentores();
    Page<MentoreRespDTO> getMentores(int offset, int pageSize);
    Mentore getMentoreById(Integer mentoreId);
    Mentore getMentoreByEmail(String email);
    Mentore getMentoreByFirstnameAndLastname(String firstname, String lastname);
    Mentore updateMentore(Mentore mentore, Integer mentoreId);
    void deleteMentore(Integer mentoreId);
}
