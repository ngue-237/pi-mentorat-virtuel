package com.logonedigital.pi_mentorat_virtuel.mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.Objectif.ObjectifReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Objectif.ObjectifResDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.PlanOrientation.PlanOrientationReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.PlanOrientation.PlanOrientationResDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface ObjectifMapper {
    Objectif fromObjectifReqDTO(ObjectifReqDTO objectifReqDTO);
    PlanOrientation fromPlanOrientationReqDTO(PlanOrientationReqDTO planOrientationReqDTO);

    ObjectifResDTO fromObjectif(Objectif objectif);
    PlanOrientationResDTO fromPlanOrientation(PlanOrientation planOrientation);
}
