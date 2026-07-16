package com.vinit.firstbackend.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>>
            handleStudentNotFound(
                    StudentNotFoundException ex) {

        Map<String, Object> response =
                new HashMap<>();

        response.put("message", ex.getMessage());
        response.put("status", 404);

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>>
            handleException(Exception ex) {

        Map<String, Object> response =
                new HashMap<>();

        response.put("message",
                "Something went wrong");
        response.put("status", 500);

        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}