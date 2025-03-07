package com.logonedigital.pi_mentorat_virtuel.services.Competency;

import com.logonedigital.pi_mentorat_virtuel.exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.Competency;
import com.logonedigital.pi_mentorat_virtuel.repositories.CompetencyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
CompetencyServiceImpl implements CompetencyService {
    private final CompetencyRepo competencyRepo;

    public CompetencyServiceImpl(CompetencyRepo competencyRepo) {
        this.competencyRepo = competencyRepo;
    }

    @Override
    public Competency addCompetency(Competency competency) {
        return this.competencyRepo.save(competency);
    }

    @Override
    public List<Competency> getAllCompetency() {
        return this.competencyRepo.findAll();
    }

    @Override
    public Competency getCompetencyById(Integer competency) {


        return null;
    }

    @Override
    public Competency updateCompetency(Competency competency, Integer competencyId) {
        Optional<Competency> competencyToEdit = this.competencyRepo.findById(competencyId);
        if (competencyToEdit.isEmpty())
            throw new ResourceNotFoundException("competency not found");
        if (competency.getName()!=null)
            competencyToEdit.get().setName(competency.getName());
        return this.competencyRepo.saveAndFlush(competencyToEdit.get());

    }

    @Override
    public void deleteCompetency(Integer competencyId) {
        this.competencyRepo.delete(this.competencyRepo.findById(competencyId)
                .orElseThrow(()-> new RuntimeException("competence not found")));

    }
}
