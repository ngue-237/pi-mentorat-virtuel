package com.logonedigital.pi_mentorat_virtuel.entities;
/*

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // L'utilisateur qui donne la note

    @ManyToOne
    @JoinColumn(name = "commentaireId", nullable = false)
    private Commentaire commentaire; // Le produit noté (ou autre élément)

    private int score; // La note (par exemple, entre 1 et 5 étoiles)
    private String comment; // Commentaire optionnel
    @Temporal(TemporalType.TIME)
    private String createdAt; // Date de la notation

    public Rating() {
    }

    public Rating(Long id, User user, Commentaire commentaire, int score, String comment, String createdAt) {
        this.id = id;
        this.user = user;
        this.commentaire = commentaire;
        this.score = score;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
*/
