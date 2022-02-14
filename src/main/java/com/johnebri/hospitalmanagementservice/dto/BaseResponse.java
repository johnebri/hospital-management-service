package com.johnebri.hospitalmanagementservice.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseResponse<T> {

    public ResponseEntity<?> getResponse(boolean status, String message, T data, HttpStatus statusCode) {
        BaseResponseWrapper<T> wrapper = new BaseResponseWrapper<>();
        wrapper.setStatus(status);
        wrapper.setMessage(message);
        wrapper.setData(data);
        return new ResponseEntity<>(wrapper, statusCode);
    }

}
