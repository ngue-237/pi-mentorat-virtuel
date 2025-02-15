package com.logonedigital.pi_mentorat_virtuel.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentaireReqDTO {
    @NotEmpty(message = "ce champ est obligatoire")
    private String contenu;
    private Boolean status;
    private Boolean isInappropriateReported ;
    private LocalDateTime dateCreation;
    private Integer postId;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Boolean getInappropriateReported() {
        return isInappropriateReported;
    }

    public void setInappropriateReported(Boolean inappropriateReported) {
        isInappropriateReported = inappropriateReported;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}
