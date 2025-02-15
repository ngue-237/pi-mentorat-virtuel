package com.logonedigital.pi_mentorat_virtuel.service.PlanOrientation;

import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;

import java.util.List;

public interface PlanOrientationService {
    PlanOrientation addPlanOrientation(PlanOrientation planOrientation);
    List<PlanOrientation> getAllPlanOrientation();
 //   Page<PlanOrientation> getplanOrientations(int offset,int pageSize);
    PlanOrientation getPlanOrientationById(Integer planId);
    void deletePlanOrientation(Integer planId);
    PlanOrientation updatePlanOrientation(PlanOrientation planOrientation,Integer planId);
}
