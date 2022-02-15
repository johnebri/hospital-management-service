package com.johnebri.hospitalmanagementservice.dto.staff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrUpdateStaffRequest {
    @NotBlank
    private String name;
}
