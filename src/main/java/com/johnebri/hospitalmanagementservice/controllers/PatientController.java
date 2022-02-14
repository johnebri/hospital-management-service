package com.johnebri.hospitalmanagementservice.controllers;

import com.johnebri.hospitalmanagementservice.dto.BaseResponse;
import com.johnebri.hospitalmanagementservice.dto.patient.DeleteMultiplePatientRequest;
import com.johnebri.hospitalmanagementservice.model.Patient;
import com.johnebri.hospitalmanagementservice.model.Staff;
import com.johnebri.hospitalmanagementservice.service.CsvService;
import com.johnebri.hospitalmanagementservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    CsvService csvService;

    @GetMapping
    public ResponseEntity<?> allPatient() {
        BaseResponse<List<Patient>> baseResponse = new BaseResponse<>();
        return baseResponse.getResponse(true, "All Patients", patientService.getAllPatients(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMultiple(@RequestBody DeleteMultiplePatientRequest request) {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        patientService.deleteMultiplePatient(request);
        return baseResponse.getResponse(true, "Patients deleted successfully", null , HttpStatus.OK);
    }

    @GetMapping("/download-profile/{patientId}")
    public void downloadPatientProfile(@PathVariable Long patientId, HttpServletResponse response) throws Exception {
        Patient patient = patientService.getPatientProfile(patientId);
        System.out.println("patient is : " + patient);
        response.setContentType("text/csv");
        response.setHeader("Content-Dispositoin", "attachment; file=patient.csv");
        csvService.downloadCsvFile(response.getWriter(), patient);
    }

//    @GetMapping("/downloadcsv")
//    public void downloadCsvFile(HttpServletResponse response) throws IOException {
//        response.setContentType("text/csv");
//        response.setHeader("Content-Dispositoin", "attachment; file=patient.csv");
//        csvService.downloadCsvFile(response.getWriter(), createDataTest());
//
//    }


}
