package com.vinit.firstbackend.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex) {

        ErrorResponse error = new ErrorResponse(
                "Validation Failed",
                400);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<ErrorResponse> handleStudentNotFoundException(
        StudentNotFoundException ex) {

    ErrorResponse error = new ErrorResponse(
            ex.getMessage(),
            404);

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
}