package com.logonedigital.pi_mentorat_virtuel.entities;


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
@Table(name = "Commentaires")
public class Comment implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column(columnDefinition = "text")
    private String content;
    @Length(min = 2, max = 60, message = "le nom doit etre min 3 et max 50 caracters")
    @NotEmpty(message = "Remplir la case")
    private String createdBy;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Temporal(TemporalType.TIME)
    private Date createdAt;



    @ManyToMany
    private List<Suje> suje = new ArrayList<>();
/*
    @OneToMany(mappedBy = "commentaire", cascade = CascadeType.ALL)
    private List<Rating> ratings;*/  // Liste des notations associées

    public Integer getCommentaireId() {
        return commentId;
    }

    public void setCommentaireId(Integer commentaireId) {
        this.commentId = commentaireId;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Suje> getSuje() {
        return suje;
    }

    public void setSuje(List<Suje> suje) {
        this.suje = suje;
    }
}

