package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.model.Patient;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService{

    @Override
    public void downloadCsvFile(PrintWriter printWriter, Patient patient) {
        printWriter.write("ID, Name, Age, Last Visit Date\n");
        printWriter.write(patient.getId() + "," + patient.getName() + "," + patient.getAge() + "," + patient.getLastVisitDate().toString());
    }

}
