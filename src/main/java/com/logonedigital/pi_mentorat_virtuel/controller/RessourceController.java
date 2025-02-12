package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.Service.Ressource.RessourceServiceImpl;
import com.logonedigital.pi_mentorat_virtuel.entities.Category;
import com.logonedigital.pi_mentorat_virtuel.entities.Ressource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation
    @PostMapping(path = "api/v1/ressource/add")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description="lorsqu'une ressource existe déjà aved un id déjà utilisé"),
            @ApiResponse(responseCode = "201", description = "lorsqu'une ressource a bien été ajouté")
    })
    public ResponseEntity<Ressource> addRessource(@RequestBody @Valid Ressource ressource){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.ressourceService.addRessource(ressource));
    }

    @GetMapping(path = "api/v1/ressource/get-all-ressources")
    public ResponseEntity<List<Ressource>> getAllRessource(){
        return ResponseEntity.status(200)
                .body(this.ressourceService.getAllRessource());
    }
    @GetMapping(path ="api/v1/ressource/get_by_id/{idRessource}")
    public ResponseEntity<Ressource> getRessourceById(@PathVariable Long idRessource){
        return ResponseEntity
                .status(200)
                .body(this.ressourceService.getRessourceByid(idRessource));
    }
    @PutMapping(path = "/ressource/update_ressource_by_id/{id}")
    public Ressource updateRessource(@RequestBody Ressource ressource, @PathVariable Long id){
        return this.ressourceService.updateRessourceByid(ressource,id);
    }
    @DeleteMapping(path = "/ressource/delete_ressource_by_id/{id}")
    public String deleteRessourceById(@PathVariable Long id){
        this.ressourceService.deleteRessourceByid(id);
        return "ressource deleted successfully !";
    }
}