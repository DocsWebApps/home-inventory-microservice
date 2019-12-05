package com.docswebapps.homeinventoryservice.web.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleMANVException(MethodArgumentNotValidException mavne) {
        List<String> errors = new ArrayList<>();
        mavne.getBindingResult()
                .getFieldErrors()
                .forEach(error-> errors.add("ERROR: " + error.getField() + " - " + error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHMNREException(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ex.getCause().getMessage());
    }

}
