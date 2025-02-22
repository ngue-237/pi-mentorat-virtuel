package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
<<<<<<< HEAD
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "Mentorés")
public class Mentore implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

=======

import java.io.Serial;
import java.time.Instant;

@Entity
@Table(name = "mentorés")
public class Mentore {
    @Serial
    private static final long serialVersionUID = 1L;
>>>>>>> main
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentoreId;
    private String firstname;
    private String lastname;
<<<<<<< HEAD
    private String email;
    @Column(name = "phone_number")
    @NotNull
    private String phone;
    @Temporal(TemporalType.TIME)
    private Date createdAt;
    @Temporal(TemporalType.TIME)
    private Date updatedAt;
=======
    private String phone;
    private String email;
    @Temporal(TemporalType.DATE)
    private Instant createdAt;
    @Temporal(TemporalType.DATE)
    private Instant updatedAt;
>>>>>>> main
    private Boolean status;

    @OneToOne
    Location location;

<<<<<<< HEAD
=======
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

>>>>>>> main
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

<<<<<<< HEAD
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

=======
>>>>>>> main
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

<<<<<<< HEAD
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
=======
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
>>>>>>> main
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
<<<<<<< HEAD
=======

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
>>>>>>> main
}