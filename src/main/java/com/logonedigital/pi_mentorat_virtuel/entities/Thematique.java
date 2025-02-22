package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Thematique {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Length(min = 3,max = 50,message = "libelle must have atleast 3 characters and at most 50 characters")
    private String libelle;
    @OneToOne
    private RDV rdv;
}
