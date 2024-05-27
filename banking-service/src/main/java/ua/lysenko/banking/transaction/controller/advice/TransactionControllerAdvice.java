package ua.lysenko.banking.transaction.controller.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.banking.exception.*;
import ua.lysenko.banking.exception.Response.ApiExceptionModel;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;

@RestControllerAdvice
public class TransactionControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TransactionUnauthorizedException.class)
    public ResponseEntity<ApiExceptionModel> handleTransactionUnauthorizedException(TransactionUnauthorizedException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TransactionLimitExceededException.class)
    public ResponseEntity<ApiExceptionModel> handleTransactionLimitExceededException(TransactionLimitExceededException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientCardBalanceException.class)
    public ResponseEntity<ApiExceptionModel> handleInsufficientBalanceException(InsufficientCardBalanceException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdenticalCardTransactionException.class)
    public ResponseEntity<ApiExceptionModel> hadnleIdenticalCardTransactionException(IdenticalCardTransactionException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(JwtExpiredException.class)
    public ResponseEntity<ApiExceptionModel> handleJwtExpiredException(JwtExpiredException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(ExceptionKeys.JWT_EXPIRED.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.UNAUTHORIZED);
    }
}