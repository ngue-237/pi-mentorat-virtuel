package com.logonedigital.pi_mentorat_virtuel.dto;

import jakarta.validation.constraints.NotEmpty;

public record LocationReqDTO (
    @NotEmpty
    String town,
    Integer postalCode,
    String street)
{
}
