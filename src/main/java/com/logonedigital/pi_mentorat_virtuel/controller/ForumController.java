package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Forum;
import com.logonedigital.pi_mentorat_virtuel.services.forum.ForumService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ForumController {
    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }
    @PostMapping(path = "forum/add")
    ResponseEntity<Forum> addForum(@Valid @RequestBody Forum forum){
        return ResponseEntity.status(201).body(this.forumService.addForum(forum));
    }

    @GetMapping(path = "forum/get_all/{offset}/{pageSize}")
    public ResponseEntity<Page<Forum>> getAllCustomer(@PathVariable int offset, @PathVariable int pageSize){

        return ResponseEntity
                .status(200)
                .body(this.forumService.getForum(offset,pageSize));
    }

    @GetMapping(path = "forum/getALL")
    public ResponseEntity<List<Forum>> getAllForum(){
       return ResponseEntity.status(200).body(this.forumService.getAllForum());
    }

    @GetMapping(path = "forum/get_by_description{description}")
    public ResponseEntity<List<Forum>> getCustomerByTitle(@PathVariable String description){

        return ResponseEntity
                .status(200)
                .body(this.forumService.getForumByDescription(description));
    }

    @GetMapping(path = "forum/getbyId{forumId}")
    public ResponseEntity<Forum> getbyId(@PathVariable Integer forumId){
        return ResponseEntity.status(200).body(this.forumService.getById(forumId));
    }
    @PutMapping(path = "forum/updated{forumId}")
    public ResponseEntity<Forum> updatedForum(@RequestBody Forum forum, @PathVariable Integer forumId){
        return ResponseEntity.status(200).body(this.forumService.updated(forum, forumId));
    }
    @DeleteMapping(path = "forum/delete{forumId}")
    public ResponseEntity<String> deleteForum(@PathVariable Integer forumId){
        this.forumService.delete(forumId);
        return ResponseEntity.status(202).body("Delete successfully");
    }

    @PutMapping("/{forumId}/forum/{sujetId}")
    public Forum liaison(@PathVariable Integer forumId, @PathVariable Integer sujetId){
        return forumService.liaison(forumId, sujetId);
    }


}
