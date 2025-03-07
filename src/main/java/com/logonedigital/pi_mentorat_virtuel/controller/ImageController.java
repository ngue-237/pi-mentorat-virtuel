package com.logonedigital.pi_mentorat_virtuel.controller;


import com.logonedigital.pi_mentorat_virtuel.entities.ImageEntity;
import com.logonedigital.pi_mentorat_virtuel.services.fonctionnaliteavance.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    private final ImageServiceImpl imageService;

    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = imageService.storeImage(file);
            return ResponseEntity.ok("Fichier enregistré: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de l'upload : " + e.getMessage());
        }
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<ImageEntity> getImage(@PathVariable String fileName) {
        ImageEntity image = imageService.getImageByName(fileName);
        return ResponseEntity.ok(image);
    }
}

