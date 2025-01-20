package com.POIs.POIs.ExceptionsHandler;

import com.POIs.POIs.Exceptions.CoordLessThanZeroException;
import com.POIs.POIs.Exceptions.DistanceLessThanOneException;
import com.POIs.POIs.Exceptions.LocationAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(LocationAlreadyExistsException.class)
    public ResponseEntity<String> LocationAlreadyExistsException(LocationAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(CoordLessThanZeroException.class)
    public ResponseEntity<String> CoordLessThanZeroException(CoordLessThanZeroException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(DistanceLessThanOneException.class)
    public ResponseEntity<String> DistanceLessThanOneException(DistanceLessThanOneException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}
