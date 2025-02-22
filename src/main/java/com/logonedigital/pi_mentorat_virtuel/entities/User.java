package com.logonedigital.pi_mentorat_virtuel.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Length(min = 2, max = 60, message = "le nom doit etre min 3 et max 50 caracters")
    @NotEmpty(message = "Remplir la case")
    private String firstname;
    private String lastname;
    @Email(message = "Your email address isn't correct")
    private String email;
    private String role;
    @Column(nullable = false, name = "phone_number")
    private Integer phone;
    @Temporal(TemporalType.TIME)
    private Date updatedAt;
    @Temporal(TemporalType.TIME)
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private List<Forum> forum = new ArrayList<>();


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public List<Forum> getForum() {
        return forum;
    }

    public void setForum(List<Forum> forum) {
        this.forum = forum;
    }

}

