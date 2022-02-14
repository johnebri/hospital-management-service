//package com.johnebri.hospitalmanagementservice.bootstrap;
//
//import com.johnebri.hospitalmanagementservice.dao.PatientRepository;
//import com.johnebri.hospitalmanagementservice.model.Patient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    PatientRepository patientRepository;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        seedPatients();
//    }
//
//    private void seedPatients() {
//        List<Patient> patients = new ArrayList<>();
//        for(int x = 1; x<=5; x++) {
//            patients.add(new Patient(null, "Tim", x, new Date()));
//        }
//
//        patients.forEach(patient -> {
//            patientRepository.save(patient);
//        });
//    }
//
//}
