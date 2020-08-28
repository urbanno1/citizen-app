package com.monycell.edu.citizenapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorMessage errorMessage = new ErrorMessage("Method argument invalid", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, status.BAD_REQUEST);
    }

    @ExceptionHandler(Adress1NotProvidedException.class)
    public final ResponseEntity<Object> handleAddress1NotProvidedException(Adress1NotProvidedException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage("Home address is Invalid", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
