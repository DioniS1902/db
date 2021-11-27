package com.lab6.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CareerNotFoundExceptionHandler {
    @ExceptionHandler(CareerNotFoundException.class)
    public ResponseEntity<Object> handleTechniqueNotFoundException(CareerNotFoundException e) {
        CareerException techniqueException = new CareerException(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(techniqueException, HttpStatus.NOT_FOUND);
    }
}
