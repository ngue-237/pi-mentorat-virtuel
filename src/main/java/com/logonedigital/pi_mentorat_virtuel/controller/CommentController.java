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
    @PostMapping(path = "comment/add")
    public ResponseEntity<Comment> add(@Valid @RequestBody Comment comment){
        return ResponseEntity.status(200).body(this.commentService.add(comment));
    }

    @GetMapping(path = "comment/get_all/{offset}/{pageSize}")
    public ResponseEntity<Page<Comment>> getAllComment(@PathVariable int offset, @PathVariable int pageSize){

        return ResponseEntity
                .status(200)
                .body(this.commentService.getComment(offset,pageSize));
    }


    @GetMapping( path = "comment/getALL")
    public ResponseEntity<List<Comment>>  getAllcoment(){
        return ResponseEntity.status(201).body(this.commentService.getAllcoment());
    }

    @GetMapping(path = "comment/getbyId{commentId}")
    public ResponseEntity<Comment> getbyId(@PathVariable Integer commentId){
        return ResponseEntity.status(201).body(this.commentService.getById(commentId));
    }

    @PutMapping(path = "comment/update{commentId}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment, @PathVariable Integer commentId){
        return ResponseEntity.status(201).body(this.commentService.updated(comment, commentId));
    }

    @DeleteMapping(path = "comment/delete{commentId}")
    public ResponseEntity<String> delete(@PathVariable Integer commentId){
        this.commentService.delete(commentId);
        return ResponseEntity.status(202).body("Comment deleted Successfully !!");
    }
}