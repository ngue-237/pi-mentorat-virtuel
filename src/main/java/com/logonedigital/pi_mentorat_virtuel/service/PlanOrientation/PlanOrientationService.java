package com.logonedigital.pi_mentorat_virtuel.service.PlanOrientation;

import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;

import java.util.List;
import java.util.Optional;

public interface PlanOrientationService {
    PlanOrientation addPlanOrientation(PlanOrientation planOrientation);
    List<PlanOrientation> getAllPlanOrientation();
    Optional<PlanOrientation> getPlanOrientationById(int id);
    Void deletePlanOrientation(int id);
    Integer updatePlanOrientation(PlanOrientation planOrientation);
}
