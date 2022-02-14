package com.johnebri.hospitalmanagementservice.dto.patient;

import lombok.Data;

import java.util.Date;

@Data
public class DeleteMultiplePatientRequest {
    private Date startDate;
    private Date endDate;
}
