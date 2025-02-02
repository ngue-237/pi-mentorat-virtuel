package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.Service.Ressource.RessourceServiceImpl;
import com.logonedigital.pi_mentorat_virtuel.entities.Ressource;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RessourceController {
    private final RessourceServiceImpl ressourceService;

    public RessourceController(RessourceServiceImpl ressourceService) {
        this.ressourceService = ressourceService;
    }
    @PostMapping("api/v1/ressource/add")
    public ResponseEntity<Ressource> addRessouce(@RequestBody @Valid Ressource ressource){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.ressourceService.addRessource(ressource));
}
    @GetMapping(path = "api/v1/ressource/get-all-ressources")
    public ResponseEntity<List<Ressource>> getAllClient(){
        return ResponseEntity.status(200)
                .body(this.ressourceService.getAllRessourceById());
    }

    @GetMapping(path ="api/v1/ressource/get_by_id/{idRessource}")
    public ResponseEntity<Ressource> getRessourceById(@PathVariable Long idRessource){
        return ResponseEntity
                .status(200)
                .body(this.ressourceService.getRessourceByid(idRessource));

    }
}