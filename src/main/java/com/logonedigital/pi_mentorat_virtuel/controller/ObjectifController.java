package com.logonedigital.pi_mentorat_virtuel.controller;


import com.logonedigital.pi_mentorat_virtuel.entities.Objectif;
import com.logonedigital.pi_mentorat_virtuel.service.Objectif.ObjectifService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/objectfs")
public class ObjectifController  {

    private final ObjectifService objectifService;

    public ObjectifController(ObjectifService objectifService) {
        this.objectifService = objectifService;
    }

    @GetMapping
    public List<Objectif> getAllobjectifs() {
        return  objectifService.getAllObjectif();
    }
    @GetMapping("/{objectifId}")
    public Object getobjectifById(@PathVariable int objectifId) {
        return objectifService.getObjectifById(objectifId);
    }
    @PostMapping(path = "objectif/add")
    @ResponseBody
    public Object addobjectif(@RequestBody Objectif objectif) {
        System.out.println("Objectif :"+objectif);
        return objectifService.addObjectif(objectif);
    }
    @PutMapping("/{objectifId}")
    public Object updateobjectif(@RequestBody Objectif objectif, @PathVariable int objectifId) {

        return objectifService.updateObjectif(objectif);
    }

    @DeleteMapping("/{objectifid}")
    public Void deleterobjectif(@PathVariable int objectifid) {
        objectifService.deleteObjectifById(objectifid);
        return null;
    }






}
