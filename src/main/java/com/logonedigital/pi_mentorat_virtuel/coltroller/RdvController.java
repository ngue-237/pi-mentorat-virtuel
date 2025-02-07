package com.logonedigital.pi_mentorat_virtuel.coltroller;

import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import com.logonedigital.pi_mentorat_virtuel.service.Rdv.RdvService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RdvController {
    private final RdvService rdvService;

    public RdvController(RdvService rdvService) {
        this.rdvService = rdvService;
    }
    @PostMapping(path = "rdv/add")
    public ResponseEntity<RDV> addrdv(@Valid @RequestBody RDV rdv){
        return  ResponseEntity
                .ok(this.rdvService.addRdv(rdv));
    }
    @GetMapping(path = "rdv/get_all")
    public ResponseEntity<List<RDV>> getAllRDV(){

        return (ResponseEntity<List<RDV>>) this.rdvService.getall();
    }

    @GetMapping(path = "rdv/get_by_id/{rdvId}")
    public ResponseEntity<RDV> getRDVById(@PathVariable Integer rdvId){

        return ResponseEntity
                .status(200)
                .body(this.rdvService.getRDVById(rdvId));
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
