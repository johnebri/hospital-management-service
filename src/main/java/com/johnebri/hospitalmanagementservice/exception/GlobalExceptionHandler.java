package com.johnebri.hospitalmanagementservice.exception;

import com.johnebri.hospitalmanagementservice.dto.BaseResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseWrapper<?>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {

        BaseResponseWrapper<?> baseResponseModel = new BaseResponseWrapper<>();

        // Get the error messages for invalid fields
        List<FieldError> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new FieldError(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(java.util.stream.Collectors.toList());
        baseResponseModel.setStatus(false);
        baseResponseModel.setMessage(errors.get(0).getField() + " " + errors.get(0).getDefaultMessage());
        return new ResponseEntity<BaseResponseWrapper<?>>(baseResponseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseResponseWrapper<?>> handleConstraintViolationException(Exception ex) {
        BaseResponseWrapper<?> baseResponseModel = new BaseResponseWrapper<>();
        baseResponseModel.setStatus(false);
        baseResponseModel.setMessage(ex.getMessage());
        logger.error("An Error has occurred: " + ex.getMessage());
        return new ResponseEntity<BaseResponseWrapper<?>>(baseResponseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseWrapper<?>> handleException(Exception ex) {
        BaseResponseWrapper<?> baseResponseModel = new BaseResponseWrapper<>();
        baseResponseModel.setStatus(false);
        baseResponseModel.setMessage(ex.getMessage());
        logger.error("An Error has occurred: " + ex.getMessage());
        return new ResponseEntity<BaseResponseWrapper<?>>(baseResponseModel, HttpStatus.BAD_REQUEST);
    }


}
