package com.tamizhselvan.pingme.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String message = "Duplicate entry detected.Duplicates Not Allowed.";

        if (ex.getRootCause() instanceof SQLException sqlEx) {
            String sqlMessage = sqlEx.getMessage();
            if (sqlMessage != null && sqlMessage.contains("email")) {
                message = "Duplicates Not allowed. This Username Email already exists.";
            }
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body(message); // 409 Conflict
    }

    // You can also handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
    }
}
