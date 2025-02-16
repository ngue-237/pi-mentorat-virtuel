package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RdvRepo extends JpaRepository<RDV,Integer> {
  /*@Query("SELECT a FROM RDV a WHERE " +
            "(:clientName is null or a.clientName LIKE %:clientName%) AND " +
            "(:dateFrom is null or a.date >= :dateFrom) AND " +
            "(:dateTo is null or a.date <= :dateTo) AND " +
            "(:serviceType is null or a.serviceType = :serviceType) AND " +
            "(:status is null or a.status = :status)")
    List<RDV> searchAppointments(
            @Param("clientName") String clientName,
            @Param("dateFrom") LocalDate dateFrom,
            @Param("dateTo") LocalDate dateTo,
            @Param("serviceType") String serviceType,
            @Param("status") String status
    );*/

  //  List<RDV> searchrdv(String clientName, LocalDate dateFrom, LocalDate dateTo, String serviceType, String status);
}



