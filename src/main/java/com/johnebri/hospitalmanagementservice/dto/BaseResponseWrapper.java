package com.johnebri.hospitalmanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseWrapper<T> {
    private boolean status;
    private String message;
    private T data;
}
