package com.logonedigital.pi_mentorat_virtuel.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentaireRespDTO {
    private Integer commentaireId;
    private String contenu;
    private Boolean status;
    private Boolean isInappropriateReported ;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
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

    public Integer getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Integer commentaireId) {
        this.commentaireId = commentaireId;
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

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }
}
