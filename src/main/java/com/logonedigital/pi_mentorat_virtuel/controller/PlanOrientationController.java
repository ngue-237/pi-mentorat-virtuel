package com.logonedigital.pi_mentorat_virtuel.controller;


import com.logonedigital.pi_mentorat_virtuel.entities.PlanOrientation;
import com.logonedigital.pi_mentorat_virtuel.service.PlanOrientation.PlanOrientationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlanOrientationController  {

    public final  PlanOrientationService planOrientationService;

    public PlanOrientationController(PlanOrientationService planOrientationService) {
        this.planOrientationService = planOrientationService;
    }

    @PostMapping(path = "PlanOrientation/add")
    public ResponseEntity<PlanOrientation> addPlanOrientation( @RequestBody PlanOrientation planOrientation) {

        return ResponseEntity
                .status(201)
                .body(planOrientationService.addPlanOrientation(planOrientation));
    }

    @GetMapping(path = "planOrientations/get_all")
    public ResponseEntity<List<PlanOrientation>>getAllPlanOrientation(){
        return ResponseEntity.status(200)
                .body(this.planOrientationService.getAllPlanOrientation());
    }
    @GetMapping(path = "planOrientation/get_by_id/{planId}")
    public ResponseEntity<PlanOrientation> getPlanOrientationById(@PathVariable Integer planId) {

        return ResponseEntity
                .status(200)
                .body(this.planOrientationService.getPlanOrientationById(planId));
    }

    @PutMapping(path = "planOrientation/update_by_id/{planId}")
    public ResponseEntity<PlanOrientation> updatePlanOrientation(@RequestBody PlanOrientation planOrientation, @PathVariable Integer planId) {

        return ResponseEntity
                .status(202)
                .body( planOrientationService.updatePlanOrientation(planOrientation,planId));
    }

    @DeleteMapping(path = "planOrientation/delete_by_id/{planId}")
    public ResponseEntity<String> deletePlanOrientationBYId(@PathVariable Integer planId) {
        this.planOrientationService.deletePlanOrientation(planId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully!");
    }




}
