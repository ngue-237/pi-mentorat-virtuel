package com.logonedigital.pi_mentorat_virtuel.services.EmailService;

import com.logonedigital.pi_mentorat_virtuel.dto.Mentore.MentoreReqDTO;

import com.logonedigital.pi_mentorat_virtuel.entities.Mentore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "activations")
public class Activation implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer validationId;
    private String code;
    private Instant createdAt;
    private Instant expiredAt;
    private Instant activation;



    public String getCode() {
        return null;
    }
    @OneToOne(cascade = CascadeType.ALL)
    private Mentore mentore;
    public MentoreReqDTO getMentore() {
        return null;
    }


}
