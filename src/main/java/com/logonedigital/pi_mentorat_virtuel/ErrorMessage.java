package com.logonedigital.pi_mentorat_virtuel;

import java.util.Date;

public record ErrorMessage(int status,
                           String msg,
                           String error,
                           Date timestamp) {
}
