package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.services.CommentaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentaireController {
    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }
    @Operation(
            summary = "Ajouter un nouveau commentaire",
            description = "Cette méthode permet d'ajouter un nouveau commentaire dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Commentaire ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PostMapping(path = "commentaire/add")
    @ResponseBody
    public ResponseEntity<Commentaire> addCommentaire(@RequestBody Commentaire commentaire){
        return ResponseEntity
                .ok(this.commentaireService.addCommentaire(commentaire));
    }
    @Operation(
            summary = "Récupérer la liste de tous les commentaires",
            description = "Cette méthode permet de récupérer tous les commentaires présents dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste de tous les commentaires a été récupérée avec succès.")
    })
    @GetMapping(path = "commentaire/get-all-commentaire")
    public ResponseEntity<List<Commentaire>> getAllCommentaire(){
        return ResponseEntity
                .ok(this.commentaireService.getAllCommentaire());
    }
    @Operation(
            summary = "Récupérer un commentaire par son identifiant",
            description = "Cette méthode permet de récupérer un commentaire spécifique en utilisant son identifiant unique dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le commentaire a été récupéré avec succès."),
            @ApiResponse(responseCode = "404", description = "Commentaire non trouvé pour l'ID donné.")
    })
    @GetMapping(path = "commentaire/get-commentaire-by-id/{commentaireId}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.getCommentaireById(commentaireId));
    }
    @Operation(
            summary = "Mettre à jour un commentaire existant",
            description = "Cette méthode permet de mettre à jour un commentaire existant dans la base de données avec de nouvelles informations."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le commentaire a été mis à jour avec succès."),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides ou incomplètes.")
    })
    @PutMapping(path = "commentaire/update-commentaire-by-id/{commentaireId}")
    public ResponseEntity<Commentaire> updateCommentaireById(@RequestBody Commentaire commentaire,@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.updateCommentaireById(commentaire, commentaireId));
    }
    @Operation(
            summary = "Supprimer un commentaire par son identifiant",
            description = "Cette méthode permet de supprimer un commentaire spécifique de la base de données en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le commentaire a été supprimé avec succès."),
            @ApiResponse(responseCode = "404", description = "Commentaire non trouvé pour l'ID donné.")
    })
    @DeleteMapping(path = "commentaire/delete-commentaire-by-id/{commentaireId}")
    public ResponseEntity<String> deleteCommentaireById(@PathVariable Integer commentaireId){
        this.commentaireService.deleteCommentaireById(commentaireId);
        return ResponseEntity
                .ok("comment deleted successfully!");
    }
}
