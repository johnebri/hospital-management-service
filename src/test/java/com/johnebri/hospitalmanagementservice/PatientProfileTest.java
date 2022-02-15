package com.johnebri.hospitalmanagementservice;

import com.johnebri.hospitalmanagementservice.dao.PatientRepository;
import com.johnebri.hospitalmanagementservice.model.Patient;
import com.johnebri.hospitalmanagementservice.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PatientProfileTest {

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private PatientService patientService;

    @Test
    public void whenGivenIdShouldReturnPatientIfFound() throws Exception {
        Patient patient = new Patient();
        patient.setId(1L);
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
        Patient expected = patientService.getPatientProfile(patient.getId());
        assertThat(expected).isSameAs(patient);
        verify(patientRepository).findById(patient.getId());
    }
}
