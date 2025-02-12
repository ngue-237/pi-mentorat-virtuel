package com.logonedigital.pi_mentorat_virtuel.services.Mentore;

import com.logonedigital.pi_mentorat_virtuel.dto.MentoreReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.MentoreRespDTO;
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
    Mentore updateMentore(Mentore mentore, Integer mentoreId);
    void deleteMentore(Integer mentoreId);
}
