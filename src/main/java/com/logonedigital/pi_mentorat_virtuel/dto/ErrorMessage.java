package com.logonedigital.pi_mentorat_virtuel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {
    private String message;
    private Integer statusCode;
    private Date timestamp;
    private String error;

}
