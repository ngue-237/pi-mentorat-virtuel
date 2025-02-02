package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private RoleName RoleName;
    private Date DateCreation;
    private Date DateModification;
    private Boolean Etat;
    @OneToOne
    private User user;
}
