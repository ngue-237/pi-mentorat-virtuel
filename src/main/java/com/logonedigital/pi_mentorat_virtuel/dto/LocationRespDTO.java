package com.logonedigital.pi_mentorat_virtuel.dto;

import lombok.Data;

@Data
public class LocationRespDTO {
    private String town;
    private Integer postalCode;
    private String street;
}
