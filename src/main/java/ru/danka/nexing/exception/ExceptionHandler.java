package ru.danka.nexing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(UnknownUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UnknownUserException unknownUserException(UnknownUserException e) {
        return e;
    }

}
