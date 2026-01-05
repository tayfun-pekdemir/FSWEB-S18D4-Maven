package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BurgerException.class)
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerException burgerException){

        BurgerErrorResponse burgerErrorResponse =
                new BurgerErrorResponse(burgerException.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, burgerException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception){
        BurgerErrorResponse burgerErrorResponse =
                new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
