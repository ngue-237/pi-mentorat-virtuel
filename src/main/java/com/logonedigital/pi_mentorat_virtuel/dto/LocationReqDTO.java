package com.logonedigital.pi_mentorat_virtuel.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LocationReqDTO {
    @NotEmpty
    private String town;
    private Integer postalCode;
    private String street;
}
