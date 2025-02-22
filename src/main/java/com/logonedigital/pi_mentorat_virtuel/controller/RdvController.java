package com.logonedigital.pi_mentorat_virtuel.controller;

import ch.qos.logback.core.model.Model;
import com.logonedigital.pi_mentorat_virtuel.dto.RdvReqDto;
import com.logonedigital.pi_mentorat_virtuel.dto.RdvResDto;
import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import com.logonedigital.pi_mentorat_virtuel.service.Rdv.RdvService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RdvController {
    private final RdvService rdvService;

    public RdvController(RdvService rdvService) {
        this.rdvService = rdvService;
    }
    @PostMapping(path = "rdv/add")
    public ResponseEntity<RdvResDto> addRDV( @RequestBody RdvReqDto rdvReqDto){
        return  ResponseEntity
                .ok(this.rdvService.addRdv(rdvReqDto));
    }
    @GetMapping(path = "rdv/get_all")
    public String getAllRDV(@RequestParam(defaultValue = "0") int page,  // Page par défaut
                            @RequestParam(defaultValue = "5") int size, // Taille de la page par défaut
                            @RequestParam(defaultValue = "debutDuRDV") String sort,  // Critère de tri par défaut
                            @RequestParam(defaultValue = "asc") String dir,    // Direction du tri par défaut
                            Model model, Pageable Pageable) {


        Sort.Direction sortDirection = dir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortObj = Sort.by(sortDirection, sort);

        // Créer un objet Pageable pour la pagination et le tri
        PageRequest pageable = PageRequest.of(page, size, sortObj);

       // Page<RDV> rdvPage = RdvRepo.findAll(pageable);


        // Ajouter les résultats et les informations de pagination au modèle

        return "rendezvous/liste";
    }

    @GetMapping(path = "rdv/get_by_id/{rdvId}")
    public ResponseEntity<RDV> getRDVById(@PathVariable Integer rdvId){

        return ResponseEntity
                .status(200)
                .body(this.rdvService.getRDVById(rdvId));
    }
    @GetMapping(path = "rdv/get-rdv-visioconference/{visioconference}")
    public ResponseEntity<RDV> getFeedBackByCommentaire(@PathVariable String visioconference){
        return ResponseEntity
                .ok(this.rdvService.findRdvByVisioconference(visioconference));
    }
    @PutMapping(path = "rdv/update_by_id/{rdvId}")
    public ResponseEntity<RDV> updateRDVById(@PathVariable Integer rdvId, @Valid @RequestBody RDV rdv){

        return ResponseEntity
                .status(202)
                .body(this.rdvService.updateRDV(rdv,rdvId));
    }

    @DeleteMapping(path = "rdv/delete_by_id/{rdvId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Integer rdvId){
        this.rdvService.deleteRDV(rdvId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }
}
