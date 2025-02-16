package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Thematique;
import com.logonedigital.pi_mentorat_virtuel.service.Thematique.ThematiqueService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThematiqueController {
    //private final ThematiqueService thematiqueService;

  //  public ThematiqueController(ThematiqueService thematiqueService) {
   //     this.thematiqueService = thematiqueService;
    //}
private final ThematiqueService thematiqueService;

    public ThematiqueController(ThematiqueService thematiqueService) {
        this.thematiqueService = thematiqueService;
    }

    @PostMapping(path = "thematique/add")
    @ResponseBody
    public ResponseEntity<Thematique> addThematique(@Valid @RequestBody Thematique thematique) {
        return ResponseEntity
                .ok(this.thematiqueService.addThematique(thematique));
    }

    @GetMapping(path = "thematique/get-thematique")
    public ResponseEntity<List<Thematique>> getThematiqueById() {
        return ResponseEntity
                .status(200)
                .body(this.thematiqueService.getAllThematique());
    }

    @GetMapping(path = "thematique/get-thematique-libelle/{libelle}")
    public ResponseEntity<Thematique> getThematiqueByLibelle(@PathVariable String libelle){
        return ResponseEntity
                .ok(this.thematiqueService.findThematiqueByLibelle(libelle));
    }
    @GetMapping(path = "thematique/get-thematique-by-id/{thematiqueId}")
    public ResponseEntity<Thematique> getThematiqueById(@PathVariable Integer thematiqueId) {
        return ResponseEntity
                .status(200)
                .body(this.thematiqueService.getThematiqueById(thematiqueId));
    }


    @PatchMapping(path = "thematique/update-by-id/{thematiqueId}")
    public ResponseEntity<Thematique> updateThematiqueById(@PathVariable Integer thematiqueId,@RequestBody Thematique thematique ){
        return  ResponseEntity
                .status(202)
                .body(this.thematiqueService.updateThematiqueById(thematique, thematiqueId));
    }
    @DeleteMapping(path = "thematique/deletethematique/{thematiqueId}")
    public ResponseEntity<String> deleteThematiqueById(@PathVariable Integer thematiqueId){
        this.thematiqueService.deleteThematique(thematiqueId);
        return ResponseEntity
                .status(202)
                .body("thematique deleted successfully");
    }


}
