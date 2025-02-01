package com.logonedigital.pi_mentorat_virtuel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Table(name = "Competency")
    public class Competency {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer CompetencyId;
        @NotEmpty(message = "le nom est obligatoire")
        @Column(nullable = false)
        private String name;
        private String description;

        public Integer getCompetencyId() {
            return CompetencyId;
        }

        public void setCompetencyId(Integer competencyId) {
            CompetencyId = competencyId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


