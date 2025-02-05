package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.services.CommentaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentaireController {
    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }
    @PostMapping(path = "commentaire/add")
    @ResponseBody
    public ResponseEntity<Commentaire> addCommentaire(@RequestBody Commentaire commentaire){
        return ResponseEntity
                .ok(this.commentaireService.addCommentaire(commentaire));
    }
    @GetMapping(path = "commentaire/get-all-commentaire")
    public ResponseEntity<List<Commentaire>> getAllCommentaire(){
        return ResponseEntity
                .ok(this.commentaireService.getAllCommentaire());
    }
    @GetMapping(path = "commentaire/get-commentaire-by-id/{commentaireId}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.getCommentaireById(commentaireId));
    }
    @PutMapping(path = "commentaire/update-commentaire-by-id/{CommentaireId}")
    public ResponseEntity<Commentaire> updateCommentaire(@RequestBody Commentaire commentaire,@PathVariable Integer commentaireId){
        return ResponseEntity
                .ok(this.commentaireService.updateCommentaire(commentaire, commentaireId));
    }
    @DeleteMapping(path = "commentaire/delete-commentaire-by-id/{commentaireId}")
    public ResponseEntity<String> deleteCommentaireById(@PathVariable Integer commentaireId){
        this.commentaireService.deleteCommentaireById(commentaireId);
        return ResponseEntity
                .ok("comment deleted successfully!");
    }
}
