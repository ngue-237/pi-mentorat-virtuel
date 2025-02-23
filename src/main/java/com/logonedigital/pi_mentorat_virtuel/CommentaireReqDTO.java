package com.logonedigital.pi_mentorat_virtuel.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentaireReqDTO {
    private String contenu;
    private Boolean status;
    private LocalDateTime dateCreation;
    private Integer postId;
    private Boolean isInappropriateReported;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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
