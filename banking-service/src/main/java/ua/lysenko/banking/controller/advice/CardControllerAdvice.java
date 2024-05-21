package ua.lysenko.banking.controller.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.banking.exception.AccountIsLockedException;
import ua.lysenko.banking.exception.CardNotFoundException;
import ua.lysenko.banking.exception.Response.ApiExceptionModel;

@RestControllerAdvice
public class CardControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountIsLockedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ApiExceptionModel> handleAccountIsLockedException(AccountIsLockedException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(CardNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiExceptionModel> handleCardNotFoundException(CardNotFoundException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.NOT_FOUND);
    }
}