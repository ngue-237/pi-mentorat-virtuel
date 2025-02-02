package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.List;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "ressources")
public class Ressource implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRessource;
    @NotEmpty(message = "Le champ description ne doit pas être vide")
    @NotBlank(message = "il y a un problème avec le remplissage de ce champ")
    @Length(min = 3, max = 30, message = "le nom doit contenir minimum 3 caractères et maximum 20 caractères")
    private String description;
    private Double prix;
    private Date creatAt;
    private Date UpdateAt;
    private Boolean etat;
    @ManyToOne
    private Category category;

    public Ressource() {
    }

    public Ressource(Integer idRessource, String description, Double prix, Date creatAt, Date updateAt, Boolean etat, Category category) {
        this.idRessource = idRessource;
        this.description = description;
        this.prix = prix;
        this.creatAt = creatAt;
        UpdateAt = updateAt;
        this.etat = etat;
        this.category = category;
    }

    public Integer getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(Integer idRessource) {
        this.idRessource = idRessource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date updateAt) {
        UpdateAt = updateAt;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

