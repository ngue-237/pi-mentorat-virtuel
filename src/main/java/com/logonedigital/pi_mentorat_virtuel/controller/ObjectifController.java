package com.logonedigital.pi_mentorat_virtuel.controller;


import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import com.logonedigital.pi_mentorat_virtuel.service.Objectif.ObjectifService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObjectifController  {

    private final ObjectifService objectifService;

    public ObjectifController(ObjectifService objectifService) {
        this.objectifService = objectifService;
    }

    @PostMapping(path = "objectif/add")
    public ResponseEntity<Objectif> addObjectif(@RequestBody Objectif objectif) {

        return ResponseEntity
                .status(201)
                .body(this.objectifService.addObjectif(objectif));
    }

    @GetMapping(path = "objectif/get_all")
    public ResponseEntity<List<Objectif>> getAllObjectif(){
        return ResponseEntity.status(200)
                .body(this.objectifService.getAllObjectif());
    }
    @GetMapping(path = "objectif/get_by_id/{objectifId}")
    public ResponseEntity<Objectif> getObjectifById(@PathVariable Integer objectifId) {

        return ResponseEntity
                .status(200)
                .body(this.objectifService.getObjectifById(objectifId));
    }

    @PutMapping(path = "objectif/update_by_id/{objectifId}")
    public ResponseEntity<Objectif> updateObjectif(@RequestBody Objectif objectif, @PathVariable Integer objectifId) {

        return ResponseEntity
                .status(202)
                .body( this.objectifService.updateObjectif(objectif,objectifId));
    }

    @DeleteMapping(path = "objectif/delete_by_id/{objectifId}")
    public ResponseEntity<String> deleteObjectifById(@PathVariable Integer objectifId) {
        this.objectifService.deleteObjectifById(objectifId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully!");
    }
}
