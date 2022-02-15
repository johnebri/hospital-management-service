package com.johnebri.hospitalmanagementservice.service.implementation;

import com.johnebri.hospitalmanagementservice.dao.PatientRepository;
import com.johnebri.hospitalmanagementservice.dto.patient.DeleteMultiplePatientRequest;
import com.johnebri.hospitalmanagementservice.model.Patient;
import com.johnebri.hospitalmanagementservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Page<Patient> getAllPatients(Pageable page) {
        return patientRepository.getPatientsUptoTwoYearsOld(page);
    }

    @Override
    public void deleteMultiplePatient(DeleteMultiplePatientRequest request) {
        List<Patient> patients = patientRepository.getPatientsWithinDateRange(request.getStartDate(), request.getEndDate());
        patientRepository.deleteAll(patients);
    }

    @Override
    public Patient getPatientProfile(Long patientId) throws Exception {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if(!patient.isPresent()) {
            throw new Exception("Patient Profile not found");
        }
        return patient.get();
    }

}
