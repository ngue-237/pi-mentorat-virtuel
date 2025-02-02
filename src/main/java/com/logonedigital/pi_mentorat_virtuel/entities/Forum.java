package com.logonedigital.pi_mentorat_virtuel.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Forum {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forumId;
    @Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters")
    @NotEmpty(message = "Remplir la case")
    private String title;
    private String slug;
    @Column(columnDefinition = "text")
    private String description;
    @Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters")
    @NotEmpty(message = "Remplir la case")
    private String createdBy;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Temporal(TemporalType.TIME)
    private Date createdAt;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "sujet_forum",
            joinColumns = @JoinColumn(name = "forumId"),
            inverseJoinColumns = @JoinColumn(name = "sujetId"))
    private List<Sujet> sujetForum = new ArrayList<>();


    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Sujet> getSujetForum() {
        return sujetForum;
    }

    public void setSujetForum(List<Sujet> sujetForum) {
        this.sujetForum = sujetForum;
    }
}

