package ua.lysenko.banking.card.controller.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.banking.exception.AccountIsLockedException;
import ua.lysenko.banking.exception.CardNotFoundException;
import ua.lysenko.banking.exception.Response.ApiExceptionModel;
import ua.lysenko.banking.exception.UnauthorizedAccessException;

@RestControllerAdvice
public class CardControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountIsLockedException.class)
    public ResponseEntity<ApiExceptionModel> handleAccountIsLockedException(AccountIsLockedException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.FORBIDDEN.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<ApiExceptionModel> handleCardNotFoundException(CardNotFoundException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ApiExceptionModel> handleCardNotFoundException(UnauthorizedAccessException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.UNAUTHORIZED);
    }
}