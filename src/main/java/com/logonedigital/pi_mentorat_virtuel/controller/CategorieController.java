package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Categrorie;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.services.CategorieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Categrorie> addCategorie(@Valid @RequestBody Categrorie categrorie){
        return ResponseEntity
                .ok(this.categorieService.addCategorie(categrorie));
    }
    @Operation(
            summary = "Recuperer la liste des categories",
            description = "Cette méthode permet de recuperer une liste complete de toutes les catégories."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "liste des categories recuperee aec success")
    })
    @GetMapping(path = "categorie/get-all-categorie")
    public ResponseEntity<List<Categrorie>> getAllCategorie(){
        return ResponseEntity
                .ok(this.categorieService.getAllCategorie());
    }
    @GetMapping(path = "categorie/pagination/{page}/{size}")
    public ResponseEntity<Page<Categrorie>> pagination(@PathVariable int page,@PathVariable int size){
        return ResponseEntity
                .ok(this.categorieService.getsPost(page, size));
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
    public ResponseEntity<Categrorie> getCategorieById(@PathVariable Integer categorieId){
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
    public ResponseEntity<Categrorie> updateCategorieById(@Valid @RequestBody Categrorie categrorie,@PathVariable Integer categorieId){
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
