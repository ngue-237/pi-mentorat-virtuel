package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

@Table
@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;
    private Integer note;
    @Column(nullable = false)
    @NotEmpty(message = "this field must not be left empty")
    private String commentaire;
    @ManyToOne
    private RDV rdv;

    public @NotEmpty(message = "this field must not be left empty") String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(@NotEmpty(message = "this field must not be left empty") String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
