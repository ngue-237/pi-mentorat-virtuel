package com.logonedigital.pi_mentorat_virtuel.entities;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "planOrientations")
public class PlanOrientation implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer planId;
    private String description;
    @Temporal(TemporalType.TIME)
    private Date createdAt;
    @Temporal(TemporalType.TIME)
    private Date updatedAt;
    private String suivi;

    @ManyToOne
    @JoinColumn(name = "objectif_id")
    private Objectif objectif;

    public PlanOrientation() {

    }


    public PlanOrientation(Integer planId, String description, Date createdAt, Date updatedAt, String suivi, Objectif objectif) {
        this.planId = planId;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.suivi = suivi;
        this.objectif = objectif;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
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

    public String getSuivi() {
        return suivi;
    }

    public void setSuivi(String suivi) {
        this.suivi = suivi;
    }

    public Objectif getObjectif() {
        return objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    @Override
    public String toString() {
        return "PlanOrientation{" +
                ",planId=" + planId +
                ",description ='" + description + '\'' +
                ", suivi='" + suivi + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", objectif=" + objectif +
                '}';
    }
}
