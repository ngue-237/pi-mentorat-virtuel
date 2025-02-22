package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
<<<<<<< HEAD
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
@Table(name = "locations")
public class Location implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

=======

import java.io.Serial;
import java.time.Instant;

@Entity
@Table(name = "locations")
public class Location {
    @Serial
    private static final long serialVersionUID = 1L;
>>>>>>> main
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;
    private String town;
    private Integer postalCode;
    private String street;
    @Temporal(TemporalType.DATE)
<<<<<<< HEAD
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    private Boolean status;

=======
    private Instant createdAt;
    @Temporal(TemporalType.DATE)
    private Instant updatedAt;
    private Boolean status;

    public Location(Integer locationId, String town, Integer postalCode, String street, Instant createdAt, Instant updatedAt, Boolean status) {
        this.locationId = locationId;
        this.town = town;
        this.postalCode = postalCode;
        this.street = street;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

>>>>>>> main
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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
>>>>>>> main
        this.updatedAt = updatedAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
