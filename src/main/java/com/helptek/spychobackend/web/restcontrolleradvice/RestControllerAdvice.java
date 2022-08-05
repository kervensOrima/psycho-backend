package com.helptek.spychobackend.web.restcontrolleradvice;

import com.helptek.spychobackend.service.exceptions.AgeInvalideException;
import com.helptek.spychobackend.service.exceptions.ObjectNotFoundException;
import com.helptek.spychobackend.utilities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@org.springframework.web.bind.annotation.RestControllerAdvice()
public class RestControllerAdvice {

    @ExceptionHandler(value = {ObjectNotFoundException.class})
    public ResponseEntity<Object> objectNotFoundException(ObjectNotFoundException exp)  {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .errorMessage(exp.getMessage())
                .code(404L)
                .timestamp(new Date())
                .module(exp.getLocalizedMessage())
                .build();
        return new ResponseEntity<Object>( errorMessage , HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exp)  {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .errorMessage(exp.getMessage())
                .code(500L)
                .timestamp(new Date())
                .module(exp.getLocalizedMessage())
                .build();
        return new ResponseEntity<Object>( errorMessage , HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(value = {AgeInvalideException.class})
    public ResponseEntity<Object> ageInvalideException(AgeInvalideException exp)  {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .errorMessage(exp.getMessage())
                .code(500L)
                .timestamp(new Date())
                .module(exp.getLocalizedMessage())
                .build();
        return new ResponseEntity<Object>( errorMessage , HttpStatus.NOT_FOUND );
    }
}
