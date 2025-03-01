package com.logonedigital.pi_mentorat_virtuel.services.Competency;

import com.logonedigital.pi_mentorat_virtuel.entities.Competency;

import java.util.List;

public interface CompetencyService {
    Competency addCompetency(Competency competency);
    List<Competency> getAllCompetency();
    Competency getCompetencyById(Integer competency);
    Competency updateCompetency(Competency competency, Integer competencyId);
    void deleteCompetency(Integer competencyId);
}
