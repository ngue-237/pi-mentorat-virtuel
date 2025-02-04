package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Competency;
import com.logonedigital.pi_mentorat_virtuel.services.CompetencyService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompetencyController {
    private final CompetencyService competencyService;

    public CompetencyController(CompetencyService competencyService) {
        this.competencyService = competencyService;
    }
    @PostMapping(path = "comptency/add")
    @ResponseBody
    public ResponseEntity<Competency> addCompetency(@Valid @RequestBody Competency competency){
        return ResponseEntity
                .status(201)
                .body(this.competencyService.addCompetency(competency));

    }
    @GetMapping(path = "comptency/get_by_id/{competencyId}")
    public ResponseEntity<Competency> getCompetencyById(@PathVariable Integer competencyId){
       return ResponseEntity
               .status(200)
               .body(this.competencyService.getCompetencyById(competencyId));

    }
    @DeleteMapping(path = "competency/delete_by_id/{competencyId}")
    public ResponseEntity<String> deleteLocationById(@PathVariable Integer competencyId){
        this.competencyService.deleteCompetency(competencyId);
        return ResponseEntity
                .status(202)
                .body("Delete successfully");
    }
}
