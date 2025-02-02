package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Commentaire;
import com.logonedigital.pi_mentorat_virtuel.service.commentaire.CommentaireService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Commentaire> add(@Valid @RequestBody Commentaire commentaire){
        return ResponseEntity.status(200).body(this.commentaireService.add(commentaire));
    }

    @GetMapping(path = "commentaire/get_all/{offset}/{pageSize}")
    public ResponseEntity<Page<Commentaire>> getAllComment(@PathVariable int offset, @PathVariable int pageSize){

        return ResponseEntity
                .status(200)
                .body(this.commentaireService.getComment(offset,pageSize));
    }


    @GetMapping( path = "commentaire/getALL")
    public ResponseEntity<List<Commentaire>>  getAllcom(){
        return ResponseEntity.status(201).body(this.commentaireService.getAllcom());
    }

    @GetMapping(path = "commentaire/getbyId{commentaireId}")
    public ResponseEntity<Commentaire> getbyId(@PathVariable Integer commentaireId){
        return ResponseEntity.status(201).body(this.commentaireService.getById(commentaireId));
    }

    @PutMapping(path = "commeentaire/update{commentaireId}")
    public ResponseEntity<Commentaire> update(@RequestBody Commentaire commentaire, @PathVariable Integer commentaireId){
        return ResponseEntity.status(201).body(this.commentaireService.updated(commentaire, commentaireId));
    }

    @DeleteMapping(path = "commentaire/delete{commentaireId}")
    public ResponseEntity<String> delete(@PathVariable Integer commentaireId){
        this.commentaireService.delete(commentaireId);
        return ResponseEntity.status(202).body("Commentaire deleted Successfully !!");
    }
}