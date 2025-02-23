package com.logonedigital.pi_mentorat_virtuel.dto.Rdv;

import java.util.Date;

public record RdvResDto(Date debutduRDV,
                        Date duree,
                        String visioconference,
                       String etat) {
}
