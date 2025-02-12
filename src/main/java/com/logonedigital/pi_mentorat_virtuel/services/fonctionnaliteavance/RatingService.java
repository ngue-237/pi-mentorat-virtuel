package com.logonedigital.pi_mentorat_virtuel.services.fonctionnaliteavance;/*package com.mentorat_virtuel.projet_mentorat_virtuel.service.fonctionnaliteavance;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Rating;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByCommentaire(Integer commentaireId) {
        return ratingRepository.findByCommentaireId(commentaireId);
    }

    public double getAverageRating(Integer commentaireId) {
        List<Rating> ratings = ratingRepository.findByCommentaireId(commentaireId);
        return ratings.stream()
                .mapToInt(Rating::getScore)
                .average()
                .orElse(0.0);
    }
}*/
