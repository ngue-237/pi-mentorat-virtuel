package com.logonedigital.pi_mentorat_virtuel.dto.forum;/*package com.mentorat_virtuel.projet_mentorat_virtuel.dto.forum;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ForumReqDTO {
    @Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters")
    @NotEmpty(message = "Remplir la case")
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    @Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters")
    @NotEmpty(message = "Remplir la case")
    private String createdBy;

    public ForumReqDTO() {}

    public ForumReqDTO(String title, String description, String createdBy) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
    }

    public @Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters") @NotEmpty(message = "Remplir la case") String getTitle() {
        return title;
    }

    public void setTitle(@Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters") @NotEmpty(message = "Remplir la case") String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters") @NotEmpty(message = "Remplir la case") String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(@Length(min = 2, max = 60, message = "le nom doit etre min 2 et max 60 caracters") @NotEmpty(message = "Remplir la case") String createdBy) {
        this.createdBy = createdBy;
    }
}*/