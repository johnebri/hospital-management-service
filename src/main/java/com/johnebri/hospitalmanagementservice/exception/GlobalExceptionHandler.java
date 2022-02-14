package com.johnebri.hospitalmanagementservice.exception;

import com.johnebri.hospitalmanagementservice.dto.BaseResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseWrapper<?>> handleException(Exception ex) {
        BaseResponseWrapper<?> baseResponseModel = new BaseResponseWrapper<>();
        baseResponseModel.setStatus(false);
        baseResponseModel.setMessage(ex.getMessage());
        return new ResponseEntity<BaseResponseWrapper<?>>(baseResponseModel, HttpStatus.BAD_REQUEST);
    }


}
