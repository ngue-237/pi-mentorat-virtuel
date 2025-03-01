package com.logonedigital.pi_mentorat_virtuel.dto.Rdv;

import com.logonedigital.pi_mentorat_virtuel.dto.FeedBack.FeedBackReqDTO;
import lombok.Data;

import java.util.Date;

@Data
public class RdvReqDto {
    public FeedBackReqDTO getFeedBackReqDTO;
    private Date debutduRDV;
    private Date duree;
    private String visioconference;
   private String etat;

    public Date getDebutduRDV() {
        return debutduRDV;
    }

    public void setDebutduRDV(Date debutduRDV) {
        this.debutduRDV = debutduRDV;
    }

    public String getVisioconference() {
        return visioconference;
    }

    public void setVisioconference(String visioconference) {
        this.visioconference = visioconference;
    }

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
    }


    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}

