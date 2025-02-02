package com.logonedigital.pi_mentorat_virtuel.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@Table(name = "Sujets")
public class Sujet implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sujetId;
    @NotEmpty(message = "Remplir la case")
    @Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters")
    private String title;
    private String slug;
    @Column(columnDefinition = "text")
    private String content;
    @Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters")
    @NotEmpty(message = "Remplir la case")
    private String createdBy;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Temporal(TemporalType.TIME)
    private Date createdAt;

    @JsonIgnore
    @ManyToMany(mappedBy = "sujetForum")
    private List<Forum> forum = new ArrayList<>();

    @ManyToMany
    private List<Commentaire> commentaire = new ArrayList<>();

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getSujetId() {
        return sujetId;
    }

    public void setSujetId(Integer sujetId) {
        this.sujetId = sujetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}

