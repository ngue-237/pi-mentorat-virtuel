package com.logonedigital.pi_mentorat_virtuel.dto.comment;/*package com.mentorat_virtuel.projet_mentorat_virtuel.dto.commentaire;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class CommentaireReqDTO {
    @Column(columnDefinition = "text")
    private String content;
    @Length(min = 2, max = 60, message = "le nom doit etre min 3 et max 50 caracters")
    @NotEmpty(message = "Remplir la case")
    private String createdBy;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Temporal(TemporalType.TIME)
    private Date createdAt;

    public CommentaireReqDTO() {
    }

    public CommentaireReqDTO(String content, String createdBy, Date updatedAt, Date createdAt) {
        this.content = content;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public @Length(min = 2, max = 60, message = "le nom doit etre min 3 et max 50 caracters") @NotEmpty(message = "Remplir la case") String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(@Length(min = 2, max = 60, message = "le nom doit etre min 3 et max 50 caracters") @NotEmpty(message = "Remplir la case") String createdBy) {
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
}*/