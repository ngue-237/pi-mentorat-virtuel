package com.logonedigital.pi_mentorat_virtuel.service.PlanOrientation;

import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import com.logonedigital.pi_mentorat_virtuel.repositories.PlanOrientationRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanOrientationServiceImpl implements PlanOrientationService {

    private final PlanOrientationRepo planOrientationRepo;

    public PlanOrientationServiceImpl(PlanOrientationRepo planOrientationRepo) {
        this.planOrientationRepo = planOrientationRepo;
    }

    @Override
    public List<PlanOrientation> getAllPlanOrientation() {
        return planOrientationRepo.findAll();
    }

    @Override
    public Optional<PlanOrientation> getPlanOrientationById(int planId) {
        return planOrientationRepo.findById(planId);
    }
    @Override
    public PlanOrientation addPlanOrientation(PlanOrientation planOrientation) {

        return planOrientationRepo.save(planOrientation);
    }
    @Override
    public Void deletePlanOrientation(int planId) {
        planOrientationRepo.deleteById(planId);
        return null;
    }

    @Override
    public Integer updatePlanOrientation(PlanOrientation planOrientation) {
        Integer updateplanOrientation= planOrientationRepo.save(planOrientation).getPlanId();

        return updateplanOrientation;
    }

    public Page<PlanOrientation> getPlanOrientqtions(Pageable pageable){
        return planOrientationRepo.findAll(pageable);
    }

}
