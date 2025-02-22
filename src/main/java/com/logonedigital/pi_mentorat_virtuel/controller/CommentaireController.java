package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.dto.Commentaire.CommentaireReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Commentaire.CommentaireRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.services.Commentaire.CommentaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
    @MessageMapping("/commentaire")
    @SendTo("/topic/commentaire")
    public ResponseEntity<CommentaireRespDTO> addCommentaire(@Valid @RequestBody CommentaireReqDTO commentaireReqDTO){

        CommentaireRespDTO addCommentaire = commentaireService.addCommentaire(commentaireReqDTO);
        return new ResponseEntity<>(addCommentaire, HttpStatus.CREATED);
    }
    @Operation(
            summary = "recuperer un commentaire inapproprie ",
            description = "Cette méthode permet recuperer commentaire comme inapproprie dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Commentaire recuperer avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @GetMapping(path = "commentaire/report/{commentaireId}")
    public ResponseEntity<Commentaire> reportInappropriateCommentaire(@PathVariable Integer commentaireId){
        Commentaire updatedCommentaire = commentaireService.reportInappropriateCommentaire(commentaireId);
        return ResponseEntity.ok(commentaireService.reportInappropriateCommentaire(commentaireId));
    }
    @GetMapping(path = "commentaire/pagination/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Commentaire>> Pagination(@PathVariable int pageNumber,@PathVariable int pageSize){
        return ResponseEntity
                .ok(this.commentaireService.getsCommentaire(pageNumber, pageSize));
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

            summary = "Récupérer la liste de tous les commentaires inapproprie",
            description = "Cette méthode permet de récupérer tous les commentaires inappropries présents dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste de tous les commentaires a été récupérée avec succès.")
    })
    @MessageMapping("/reported")
    @SendTo("/topic/commentaire")
    @GetMapping(path = "commentaire/reported")
    public ResponseEntity<List<Commentaire>> getReportedCommentaire(){
        List<Commentaire> reportedCommentaire = commentaireService.getReportedComments();
        return ResponseEntity.ok(this.commentaireService.getReportedComments());
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
    public ResponseEntity<Commentaire> updateCommentaireById(@Valid @RequestBody Commentaire commentaire,@PathVariable Integer commentaireId){
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
