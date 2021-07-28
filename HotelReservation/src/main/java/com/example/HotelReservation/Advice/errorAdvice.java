package com.example.HotelReservation.Advice;

import com.example.HotelReservation.exception.GenderInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class errorAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException genderInput) {
        return new ResponseEntity<String>("Gender Field Should be in Caps", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(GenderInput.class)
    public ResponseEntity<String> handleGenderInput(GenderInput genderInput) {
        return new ResponseEntity<String>("Gender Field Should be in Caps", HttpStatus.BAD_REQUEST);

    }

}
