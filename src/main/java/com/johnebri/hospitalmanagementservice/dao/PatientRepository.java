package com.johnebri.hospitalmanagementservice.dao;

import com.johnebri.hospitalmanagementservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE (p.age >= 2)")
    List<Patient> getPatientsUptoTwoYearsOld();

    @Query("SELECT p FROM Patient p WHERE p.lastVisitDate BETWEEN ?1 AND ?2")
    List<Patient> getPatientsWithinDateRange(Date startDate, Date endDate);
}
