package com.logonedigital.pi_mentorat_virtuel.dto.Categorie;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategorieReqDTO {
    private String nom;
    private String description;
    private Boolean status;
    private LocalDateTime dateCreation;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
