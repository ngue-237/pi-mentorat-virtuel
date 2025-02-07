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
    @OneToOne
    private Thematique thematique;
    @OneToMany(mappedBy = "rdv")
    private List<FeedBack> feedback = new ArrayList<>();


}
