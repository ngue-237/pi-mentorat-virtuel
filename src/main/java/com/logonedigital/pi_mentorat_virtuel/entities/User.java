package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String password;
    private RoleName roleName;
    private String passwordConfirm;
    private Date DateCreation;
    @OneToOne
    private Role role;
    private Date dateCreation;
    private Date dateModification;
    private Boolean isActivated;
    private Boolean isBlocked;
}
