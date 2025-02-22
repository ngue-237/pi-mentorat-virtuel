package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Suje;
import com.logonedigital.pi_mentorat_virtuel.services.sujet.SujeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SujeController {
    private final SujeService sujeService;

    public SujeController(SujeService sujeService) {

        this.sujeService = sujeService;
    }

    @PostMapping(path = "sujet/add")
    public ResponseEntity<Suje> add(@RequestBody Suje suje){
        return ResponseEntity.status(201).body(this.sujeService.add(suje));
    }

    @GetMapping(path = "sujet/get_by_orderAsc")
    public ResponseEntity<List<Suje>> getSujetOrderByTitleAsc(){

        return ResponseEntity
                .status(200)
                .body(this.sujeService.findByOrderByAsc());
    }

    @GetMapping(path = "sujet/get_all/{offset}/{pageSize}")
    public ResponseEntity<Page<Suje>> getAllCustomer(@PathVariable int offset, @PathVariable int pageSize){

        return ResponseEntity
                .status(200)
                .body(this.sujeService.getSujet(offset,pageSize));
    }


    @GetMapping(path = "sujet/getAll")
    public ResponseEntity<List<Suje>> getAll(){
        return ResponseEntity.status(200).body(this.sujeService.getAllSujet());
    }

    @GetMapping( path = "sujet/getbyId{sujetId}")
    public ResponseEntity<Suje> getbyid(@PathVariable Integer sujetId){
        return ResponseEntity.status(200).body(this.sujeService.getById(sujetId));
    }

    @PutMapping( path = "sujet/updated{sujetId}")
    public ResponseEntity<Suje> updated(@RequestBody Suje suje, @PathVariable Integer sujetId){
        return ResponseEntity.status(200).body(this.sujeService.updated(suje, sujetId));
    }

    @DeleteMapping( path = "sujet/delete{sujetId}")
    public ResponseEntity<String> delete(Integer sujetId){
        this.sujeService.delete(sujetId);
        return ResponseEntity.status(202).body("Delete sucessfully !!");
    }
}
