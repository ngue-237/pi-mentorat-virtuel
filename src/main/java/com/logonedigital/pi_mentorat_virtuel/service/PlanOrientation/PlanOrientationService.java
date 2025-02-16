package com.logonedigital.pi_mentorat_virtuel.service.PlanOrientation;

import com.logonedigital.pi_mentorat_virtuel.dto.PlanOrientationReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.PlanOrientationResDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlanOrientationService {
    PlanOrientationResDTO addPlanOrientation(PlanOrientationReqDTO planOrientationReqDTO);
    List<PlanOrientation> getAllPlanOrientation();
    Page<PlanOrientationResDTO> getplanOrientations(int offset, int pageSize);
    PlanOrientation getPlanOrientationById(Integer planId);
    void deletePlanOrientation(Integer planId);
    PlanOrientation updatePlanOrientation(PlanOrientation planOrientation,Integer planId);
}
