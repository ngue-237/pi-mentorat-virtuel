package com.logonedigital.pi_mentorat_virtuel.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
public class MentoreReqDTO {
    @Column(nullable = false)
    @Length(min = 3, max = 50, message = "firstname must have min 3 caracters and max 50 caracters")
    @NotEmpty(message = "This field must be fill")
    private String firstname;
    private String lastname;
    @NotEmpty(message = "the email does not be Empty")
    @Email(message = "Your email address isn't correct")
    private String email;
    @Column(name = "phone_number")
    private String phone;
    private LocationReqDTO locationReqDTO;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocationReqDTO getLocationReqDTO() {
        return locationReqDTO;
    }

    public void setLocationReqDTO(LocationReqDTO locationReqDTO) {
        this.locationReqDTO = locationReqDTO;
    }
}
