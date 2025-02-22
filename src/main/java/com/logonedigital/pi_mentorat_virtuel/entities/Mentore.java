package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.Instant;

@Entity
@Table(name = "mentorés")
public class Mentore {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentoreId;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    @Temporal(TemporalType.DATE)
    private Instant createdAt;
    @Temporal(TemporalType.DATE)
    private Instant updatedAt;
    private Boolean status;

    @OneToOne
    Location location;

    public Mentore(Integer mentoreId, String firstname, String lastname, String phone, String email, Instant createdAt, Instant updatedAt, Location location, Boolean status) {
        this.mentoreId = mentoreId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.location = location;
        this.status = status;
    }

    public Integer getMentoreId() {
        return mentoreId;
    }

    public void setMentoreId(Integer mentoreId) {
        this.mentoreId = mentoreId;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
