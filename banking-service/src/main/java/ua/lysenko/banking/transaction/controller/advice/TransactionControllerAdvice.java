package ua.lysenko.banking.transaction.controller.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.banking.exception.Response.ApiExceptionModel;
import ua.lysenko.banking.exception.TransactionLimitExceededException;
import ua.lysenko.banking.exception.TransactionUnauthorizedException;

@RestControllerAdvice
public class TransactionControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TransactionUnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ApiExceptionModel> handleTransactionUnauthorizedException(TransactionUnauthorizedException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(TransactionLimitExceededException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ApiExceptionModel> handleTransactionLimitExceededException(TransactionLimitExceededException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.UNAUTHORIZED);
    }
}