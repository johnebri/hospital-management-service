package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.dto.patient.DeleteMultiplePatientRequest;
import com.johnebri.hospitalmanagementservice.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    Page<Patient> getAllPatients(Pageable page);
    void deleteMultiplePatient(DeleteMultiplePatientRequest request);
    Patient getPatientProfile(Long patientId) throws Exception;
}
