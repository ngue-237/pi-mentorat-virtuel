package com.logonedigital.pi_mentorat_virtuel.Exception;


import com.logonedigital.pi_mentorat_virtuel.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RestController
public class GlobalHandlerException {

    @ExceptionHandler(ResourceExistException.class)
    public ResponseEntity<ErrorMessage> resourceExisteException(Exception e){
        return ResponseEntity.status(400).body(new ErrorMessage(400, e.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new Date()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage>  resourceNotFoundException(Exception e){

        return ResponseEntity.status(404).body(new ErrorMessage(404, e.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), new Date()));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
