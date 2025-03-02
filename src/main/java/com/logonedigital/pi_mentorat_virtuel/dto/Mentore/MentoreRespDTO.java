package com.logonedigital.pi_mentorat_virtuel.dto.Mentore;

import com.logonedigital.pi_mentorat_virtuel.dto.Location.LocationRespDTO;
import lombok.Data;

@Data
public class MentoreRespDTO {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Boolean status;
    private LocationRespDTO locationRespDTO;

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocationRespDTO getLocationRespDTO() {
        return locationRespDTO;
    }

    public void setLocationRespDTO(LocationRespDTO locationRespDTO) {
        this.locationRespDTO = locationRespDTO;
    }
}
