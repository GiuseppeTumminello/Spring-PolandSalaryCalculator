package com.acoustic.SpringPolandSalaryCalculator.exception;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.RequiredArgsConstructor;


@ControllerAdvice
@RequiredArgsConstructor
public class NotValidSalaryExceptionHandler {

    private NotValidSalaryErrorResponse notValidSalaryErrorResponse;

    @ExceptionHandler
    public ResponseEntity<NotValidSalaryErrorResponse> notValidSalaryException(NotValidSalaryException exception){
        notValidSalaryErrorResponse.setMessage("The salary must be a numeric value and must be greater than 2000.0");
        notValidSalaryErrorResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        notValidSalaryErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(notValidSalaryErrorResponse, HttpStatus.NOT_ACCEPTABLE);
    }
}
