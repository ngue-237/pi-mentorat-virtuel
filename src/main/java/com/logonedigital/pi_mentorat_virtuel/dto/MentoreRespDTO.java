package com.logonedigital.pi_mentorat_virtuel.dto;

import lombok.Data;

@Data
public class MentoreRespDTO {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Boolean status;
    private LocationRespDTO locationRespDTO;
}
