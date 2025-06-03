package com.example.api_conserto_carro.handler_error;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerError {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handle404Error(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handle400Error(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        var list = errors.stream().map(ValidationErrorData::new).toList();
        return ResponseEntity.badRequest().body(list);
    }

    private record ValidationErrorData(String campo, String msgErro){

        public ValidationErrorData(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }
}
