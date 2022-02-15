package com.johnebri.hospitalmanagementservice.dto.patient;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class DeleteMultiplePatientRequest {
    @NotBlank
    private Date startDate;
    @NotBlank
    private Date endDate;
}
