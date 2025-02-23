package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.CategorieReqDTO;
import com.logonedigital.pi_mentorat_virtuel.CategorieRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Categorie;
import com.logonedigital.pi_mentorat_virtuel.services.CategorieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }
    @Operation(
            summary = "Ajouter une nouvelle catégorie",
            description = "Cette méthode permet d'ajouter une nouvelle catégorie dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Catégorie ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PostMapping(path = "categorie/add")
    @ResponseBody
    public ResponseEntity<CategorieRespDTO> addCategorie(@Valid @RequestBody CategorieReqDTO categorieReqDTO){

        CategorieRespDTO addCategorie = categorieService.addCategorie(categorieReqDTO);
        return new ResponseEntity<>(addCategorie, HttpStatus.CREATED);

    }
    @Operation(
            summary = "Recuperer la liste des categories",
            description = "Cette méthode permet de recuperer une liste complete de toutes les catégories."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "liste des categories recuperee aec success")
    })
    @GetMapping(path = "categorie/get-all-categorie")
    public ResponseEntity<List<Categorie>> getAllCategorie(){
        return ResponseEntity
                .ok(this.categorieService.getAllCategorie());
    }
    @GetMapping(path = "categorie/pagination/{page}/{size}")
    public ResponseEntity<Page<CategorieRespDTO>> pagination(@PathVariable int page, @PathVariable int size){
        return ResponseEntity
                .ok(this.categorieService.getsCategorie(page, size));
    }

    @Operation(
            summary = "Récupérer une catégorie par son identifiant",
            description = "Cette méthode permet de récupérer une catégorie spécifique en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La catégorie a été récupérée avec succès."),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée pour l'ID donné.")
    })
    @GetMapping(path = "categorie/get-categorie-by-id/{categorieId}")
    public ResponseEntity<CategorieRespDTO> getCategorieById(@PathVariable Integer categorieId){
        return ResponseEntity
                .ok(this.categorieService.getCategorieById(categorieId));
    }
    @Operation(
            summary = "Mettre à jour une catégorie existante",
            description = "Cette méthode permet de mettre à jour les informations d'une catégorie existante dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La catégorie a été mise à jour avec succès."),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides ou incomplètes.")
    })
    @PutMapping(path = "categorie/update-categorie-by-id/{categorieId}")
    public ResponseEntity<Categorie> updateCategorieById(@Valid @RequestBody Categorie categrorie, @PathVariable Integer categorieId){
        return ResponseEntity
                .ok(this.categorieService.updateCategorie(categrorie, categorieId));
    }
    @Operation(
            summary = "Supprimer une catégorie par son identifiant",
            description = "Cette méthode permet de supprimer une catégorie de la base de données en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie supprimée avec succès."),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée pour l'ID donné.")
    })
    @DeleteMapping(path = "categorie/delete-categorie-by-id/{categorieId}")
    public ResponseEntity<String> deleteCategorieById(@PathVariable Integer categorieId){
        this.categorieService.deleteCategorieById(categorieId);
        return ResponseEntity
                .ok("category deleted successfully!");
    }

}
