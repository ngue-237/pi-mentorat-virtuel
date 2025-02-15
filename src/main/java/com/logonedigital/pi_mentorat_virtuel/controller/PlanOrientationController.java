package com.logonedigital.pi_mentorat_virtuel.controller;


import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import com.logonedigital.pi_mentorat_virtuel.service.PlanOrientation.PlanOrientationService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/planOrientations")
public class PlanOrientationController  {

    private PlanOrientationService planOrientationService;



    @GetMapping("/{planId}")
    public Optional<PlanOrientation> getPlanOrientationById(@PathVariable int planId) {
        return this.planOrientationService.getPlanOrientationById(planId);
    }
    @PostMapping
    public PlanOrientation createPlanOrientation(@RequestBody PlanOrientation planOrientation) {

        return planOrientationService.addPlanOrientation(planOrientation);
    }
    @PutMapping
    public Object updatePlanOrientation(@RequestBody PlanOrientation planOrientation, @PathVariable int planId) {

        return planOrientationService.updatePlanOrientation(planOrientation);
    }

    @DeleteMapping("/{planId}")
    public void deletePlanOrientation(@PathVariable int planId) {
        planOrientationService.deletePlanOrientation(planId);
    }




}
