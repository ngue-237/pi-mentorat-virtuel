package com.logonedigital.pi_mentorat_virtuel.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class CategorieReqDTO {
    @NotEmpty(message = "ce champ est obligatoire")
    @Length(min = 3,message = "ce champ doit contenir au moins 3 caractere")
    private String nom;
    @NotEmpty(message = "ce champ est obligatoire")
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
