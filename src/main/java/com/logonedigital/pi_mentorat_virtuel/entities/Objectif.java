package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "objectifs")
public class Objectif implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer ObjectifId;

    private String libelle;
    private  String domaine;
    private String description;
    @Temporal(TemporalType.TIME)
    private Date createdAt;
    @Temporal(TemporalType.TIME)
    private Date updatedAt;
    private Boolean status;

    @OneToMany(mappedBy = "objectif", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PlanOrientation > planOrientations;

    public Objectif() {
    }

    public Objectif(Integer objectifId, String libelle, String domaine, String description, Date createdAt, Date updatedAt, Boolean status, List<PlanOrientation> planOrientations) {
        ObjectifId = objectifId;
        this.libelle = libelle;
        this.domaine = domaine;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.planOrientations = planOrientations;
    }

    public Integer getObjectifId() {
        return ObjectifId;
    }

    public void setObjectifId(Integer objectifId) {
        ObjectifId = objectifId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<PlanOrientation> getPlanOrientations() {
        return planOrientations;
    }

    public void setPlanOrientations(List<PlanOrientation> planOrientations) {
        this.planOrientations = planOrientations;
    }



    @Override
    public String toString() {
        return "Objectif{" +
                "ObjectifId=" + ObjectifId +
                ", libelle='" + libelle + '\'' +
                ", domaine='" + domaine + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                ", planOrientations=" + planOrientations +
                '}';
    }
}
