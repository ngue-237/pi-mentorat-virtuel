package com.logonedigital.pi_mentorat_virtuel.dto.userDto;

public record UserReqDTO(
        String nom,
        String prenom,
        String tel,
        String email,
        String password,
        String passwordConfirm
) {
}
