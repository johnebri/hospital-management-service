package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.model.Patient;

import java.io.PrintWriter;
import java.util.List;

public interface CsvService {
    public void downloadCsvFile(PrintWriter printWriter, Patient patient);
}
