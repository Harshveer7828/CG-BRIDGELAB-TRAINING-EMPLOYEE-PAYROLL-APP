package com.bridgelabz.employeepayrollapp.exception;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        HashMap<String,String> error = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(errors-> error.put(errors.getField(),errors.getDefaultMessage()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String,String>> handleNoSuchElementFound(NoSuchElementException exception){
        HashMap<String,String> error = new HashMap<>();
        error.put(exception.getMessage(),"ID Not found in the database !");
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
