package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.dto.patient.DeleteMultiplePatientRequest;
import com.johnebri.hospitalmanagementservice.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    void deleteMultiplePatient(DeleteMultiplePatientRequest request);
    Patient getPatientProfile(Long patientId) throws Exception;
}
