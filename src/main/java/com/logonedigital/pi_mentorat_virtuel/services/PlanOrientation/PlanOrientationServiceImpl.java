package com.logonedigital.pi_mentorat_virtuel.services.PlanOrientation;

import com.logonedigital.pi_mentorat_virtuel.exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.dto.PlanOrientation.PlanOrientationReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.PlanOrientation.PlanOrientationResDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import com.logonedigital.pi_mentorat_virtuel.mapper.ObjectifMapper;
import com.logonedigital.pi_mentorat_virtuel.repositories.PlanOrientationRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlanOrientationServiceImpl implements PlanOrientationService {

    private final PlanOrientationRepo planOrientationRepo;
    private final ObjectifMapper objectifMapper;

    public PlanOrientationServiceImpl(PlanOrientationRepo planOrientationRepo, ObjectifMapper objectifMapper) {
        this.planOrientationRepo = planOrientationRepo;
        this.objectifMapper = objectifMapper;
    }
    @Override
    public PlanOrientationResDTO addPlanOrientation(PlanOrientationReqDTO planOrientationReqDTO) {
PlanOrientation planOrientation=this.objectifMapper.fromPlanOrientationReqDTO(planOrientationReqDTO);
        planOrientation.setCreatedAt(new Date());
        planOrientation.setStatus(true);
        return this.objectifMapper.fromPlanOrientation(this.planOrientationRepo.save(planOrientation));
    }

    @Override
    public List<PlanOrientation> getAllPlanOrientation() {

        return  this.planOrientationRepo.findAll();
    }

    @Override
      public Page<PlanOrientationResDTO> getplanOrientations(int offset, int pageSize) {
        return this.planOrientationRepo.findAll(PageRequest.of(offset,pageSize, Sort.by(Sort.Direction.DESC,"createdAt")))
                .map(this.objectifMapper::fromPlanOrientation);
    }

    @Override
    public PlanOrientation getPlanOrientationById(Integer planId) {

        return this.planOrientationRepo.findById(planId).orElseThrow(
                ()-> new ResourceNotFoundException("plan Orientation not found!")
        );
    }

    @Override
    public void deletePlanOrientation(Integer planId) {
        PlanOrientation planOrientation= this.planOrientationRepo.findById(planId)
                .orElseThrow(()-> new ResourceNotFoundException("Orientation plan not found!"));
        this.planOrientationRepo.delete(planOrientation);
    }

    @Override
    public PlanOrientation updatePlanOrientation(PlanOrientation planOrientation, Integer planId) {
        Optional<PlanOrientation> planOrientationToEdit=this.planOrientationRepo.findById(planId);
        if(planOrientationToEdit.isEmpty())
            throw new ResourceNotFoundException("Orientation plan not found!");
        if (planOrientation.getSuivi()!=null)
            planOrientationToEdit.get().setSuivi(planOrientation.getSuivi());
        if (planOrientation.getDescription()!=null)
            planOrientationToEdit.get().setDescription(planOrientation.getDescription());
        planOrientationToEdit.get().setUpdatedAt(new Date());
        return this.planOrientationRepo.saveAndFlush(planOrientationToEdit.get());
    }

}
