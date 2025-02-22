package com.logonedigital.pi_mentorat_virtuel.dto;

import jakarta.persistence.Column;
import org.hibernate.validator.constraints.NotEmpty;

public class FeedBackReqDTO{
    private Integer note;
    @Column(nullable = false)
    @NotEmpty(message = "this field must not be left empty")
    private String commentaire;
}
