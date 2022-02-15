package com.johnebri.hospitalmanagementservice.controllers;

import com.johnebri.hospitalmanagementservice.dto.BaseResponse;
import com.johnebri.hospitalmanagementservice.dto.patient.DeleteMultiplePatientRequest;
import com.johnebri.hospitalmanagementservice.model.Patient;
import com.johnebri.hospitalmanagementservice.model.Staff;
import com.johnebri.hospitalmanagementservice.service.CsvService;
import com.johnebri.hospitalmanagementservice.service.PatientService;
import com.johnebri.hospitalmanagementservice.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    ValidationService validationService;

    @Autowired
    CsvService csvService;

    @GetMapping
    public ResponseEntity<?> patientsUpToTwoYears(Pageable page, @RequestHeader("Authorization") String authorization) throws Exception {
        // validate uuid
        validationService.validateUuid(authorization);
        BaseResponse<Page<Patient>> baseResponse = new BaseResponse<>();
        return baseResponse.getResponse(true, "Patients up to 2 years of age", patientService.getAllPatients(page), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMultiple(@Valid @RequestBody DeleteMultiplePatientRequest request, @RequestHeader("Authorization") String authorization) throws Exception {
        // validate uuid
        validationService.validateUuid(authorization);
        BaseResponse<String> baseResponse = new BaseResponse<>();
        patientService.deleteMultiplePatient(request);
        return baseResponse.getResponse(true, "Patients deleted successfully", null , HttpStatus.OK);
    }

    @GetMapping("/download-profile/{patientId}")
    public void downloadPatientProfile(@PathVariable Long patientId, HttpServletResponse response, @RequestHeader("Authorization") String authorization) throws Exception {
        // validate uuid
        validationService.validateUuid(authorization);

        // get and download patient profile
        Patient patient = patientService.getPatientProfile(patientId);
        response.setContentType("text/csv");
        response.setHeader("Content-Dispositoin", "attachment; file=patient_profile.csv");
        csvService.downloadCsvFile(response.getWriter(), patient);
    }

}
