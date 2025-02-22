package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Comment;
import com.logonedigital.pi_mentorat_virtuel.services.comment.CommentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping(path = "commentaire/add")
    public ResponseEntity<Comment> add(@Valid @RequestBody Comment comment){
        return ResponseEntity.status(200).body(this.commentService.add(comment));
    }

    @GetMapping(path = "commentaire/get_all/{offset}/{pageSize}")
    public ResponseEntity<Page<Comment>> getAllComment(@PathVariable int offset, @PathVariable int pageSize){

        return ResponseEntity
                .status(200)
                .body(this.commentService.getComment(offset,pageSize));
    }


    @GetMapping( path = "commentaire/getALL")
    public ResponseEntity<List<Comment>>  getAllcom(){
        return ResponseEntity.status(201).body(this.commentService.getAllcom());
    }

    @GetMapping(path = "commentaire/getbyId{commentaireId}")
    public ResponseEntity<Comment> getbyId(@PathVariable Integer commentaireId){
        return ResponseEntity.status(201).body(this.commentService.getById(commentaireId));
    }

    @PutMapping(path = "commeentaire/update{commentaireId}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment, @PathVariable Integer commentaireId){
        return ResponseEntity.status(201).body(this.commentService.updated(comment, commentaireId));
    }

    @DeleteMapping(path = "commentaire/delete{commentaireId}")
    public ResponseEntity<String> delete(@PathVariable Integer commentaireId){
        this.commentService.delete(commentaireId);
        return ResponseEntity.status(202).body("Commentaire deleted Successfully !!");
    }
}