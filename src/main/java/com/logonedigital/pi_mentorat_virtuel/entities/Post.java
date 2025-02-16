package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @NotEmpty(message = "ce champ est obligatoire")
    private String nom;
    @NotEmpty(message = "ce champ est obligatoire")
    private String contenu;
    private Boolean status;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    @ManyToOne
    @JoinColumn(name = "categorieId")
    private Categorie categorie;
    @OneToMany(mappedBy = "post")
    private List<Commentaire> commentaires;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }
}
