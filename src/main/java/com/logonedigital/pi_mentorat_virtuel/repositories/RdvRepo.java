package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RdvRepo extends JpaRepository<RDV,Integer> {
/*
  @Query("SELECT r FROM RDV r WHERE " +
            "(:visioconference is null or r.visioconference LIKE %:visioconference%) AND " +
            "(:debutdurdv is null or r.date >= :debutduedv) AND " +
            "(:duree is null or r.date <= :duree) AND " +

            "(:etat is null or r.etat= :etat)")
    List<RDV> searchrdv(
            @Param("visioconference") String visioconference,
            @Param("debutduRDV") LocalDate dateFrom,
            @Param("duree") LocalDate dateTo,

            @Param("etat") String etat
    );

    Optional<RDV> searchrdv(String visioconference, Date debutdurdv, Date duree, String etat);

 */
@Query("select r from RDV r where r.visioconference = :" +
        "visioconference")
Optional<RDV> findRDVByVisioconference(@Param("visioconference") String visioconference);
}



