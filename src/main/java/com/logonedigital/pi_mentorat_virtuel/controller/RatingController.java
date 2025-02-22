package com.logonedigital.pi_mentorat_virtuel.controller;/*package com.mentorat_virtuel.projet_mentorat_virtuel.controller;


import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Rating;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.fonctionnaliteavance.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        Rating newRating = ratingService.addRating(rating);
        return ResponseEntity.ok(newRating);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getRatingsByProduct(@PathVariable Integer commentaireId) {
        return ResponseEntity.ok(ratingService.getRatingsByCommentaire(commentaireId));
    }

    @GetMapping("/product/{productId}/average")
    public ResponseEntity<Double> getAverageRating(@PathVariable Integer commentaireId) {
        return ResponseEntity.ok(ratingService.getAverageRating(commentaireId));
    }
}*/