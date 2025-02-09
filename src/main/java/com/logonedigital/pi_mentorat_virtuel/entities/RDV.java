package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Table
@Entity
@Getter
@Setter
public class RDV {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Timestamp debutduRDV;
    private String duree;
    private String visioconference;
private String etat;
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getVisioconference() {
        return visioconference;
    }

    public void setVisioconference(String visioconference) {
        this.visioconference = visioconference;
    }

    public Timestamp getDebutduRDV() {
        return debutduRDV;
    }

    public void setDebutduRDV(Timestamp debutduRDV) {
        this.debutduRDV = debutduRDV;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public List<FeedBack> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<FeedBack> feedback) {
        this.feedback = feedback;
    }

    @OneToOne
    private Thematique thematique;
    @OneToMany(mappedBy = "rdv")
    private List<FeedBack> feedback = new ArrayList<>();


}
