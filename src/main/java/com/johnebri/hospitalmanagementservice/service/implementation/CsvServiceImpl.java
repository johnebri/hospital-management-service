package com.johnebri.hospitalmanagementservice.service.implementation;

import com.johnebri.hospitalmanagementservice.model.Patient;
import com.johnebri.hospitalmanagementservice.service.CsvService;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;

@Service
public class CsvServiceImpl implements CsvService {

    @Override
    public void downloadCsvFile(PrintWriter printWriter, Patient patient) {
        printWriter.write("ID, Name, Age, Last Visit Date\n");
        printWriter.write(patient.getId() + "," + patient.getName() + "," + patient.getAge() + "," + patient.getLastVisitDate().toString());
    }

}
