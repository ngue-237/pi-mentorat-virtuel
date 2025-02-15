package com.logonedigital.pi_mentorat_virtuel.service.PlanOrientation;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import com.logonedigital.pi_mentorat_virtuel.repositories.PlanOrientationRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlanOrientationServiceImpl implements PlanOrientationService {

    private final PlanOrientationRepo planOrientationRepo;

    public PlanOrientationServiceImpl(PlanOrientationRepo planOrientationRepo) {
        this.planOrientationRepo = planOrientationRepo;
    }
    @Override
    public PlanOrientation addPlanOrientation(PlanOrientation planOrientation) {

        planOrientation.setCreatedAt(new Date());
        planOrientation.setStatus(true);
        return this.planOrientationRepo.saveAndFlush(planOrientation);
    }

    @Override
    public List<PlanOrientation> getAllPlanOrientation() {

        return  this.planOrientationRepo.findAll();
    }

   // @Override
    //  public Page<PlanOrientation> getplanOrientations(int offset, int pageSize) {
       // return this.planOrientationRepo.findAll(PageRequest.of(offset,pageSize, Sort.by(Sort.Direction.DESC,"createdAt")))
              //  .map(this.)
   // }

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
