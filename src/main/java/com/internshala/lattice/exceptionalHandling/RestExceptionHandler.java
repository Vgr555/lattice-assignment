package com.internshala.lattice.exceptionalHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NoSuchDoctorException.class)
    public ResponseEntity<ErrorInfo> noSuchDoctorException(NoSuchDoctorException ex){
        ErrorInfo errorInfo = new ErrorInfo(400, ex.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchPatientException.class)
    public ResponseEntity<ErrorInfo> noSuchPatientException(NoSuchPatientException ex){
        ErrorInfo errorInfo = new ErrorInfo(400, ex.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DoctorNotAvailableException.class)
    public ResponseEntity<ErrorInfo> doctorNotAvailableException(DoctorNotAvailableException ex){
        ErrorInfo errorInfo = new ErrorInfo(200, ex.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.OK);
    }

    @ExceptionHandler(LocationUnAvailable.class)
    public ResponseEntity<ErrorInfo> locationUnAvailable(LocationUnAvailable ex){
        ErrorInfo errorInfo = new ErrorInfo(200, ex.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.OK);
    }

}
