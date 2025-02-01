package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "commentaire")
public class Commentaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentaireId;
    private String contenu;
    private Boolean status;
    private Date createdAt;
    private Date updateAt;
}
