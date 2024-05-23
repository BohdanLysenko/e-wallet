package ua.lysenko.banking.transaction.controller.advice;


import io.grpc.StatusRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.banking.exception.InsufficientCardBalanceException;
import ua.lysenko.banking.exception.Response.ApiExceptionModel;
import ua.lysenko.banking.exception.TransactionLimitExceededException;
import ua.lysenko.banking.exception.TransactionUnauthorizedException;
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

    @ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<ApiExceptionModel> handleStatusRunTimeException(StatusRuntimeException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(ExceptionKeys.SERVICE_UNAVAILABLE.getMessage())
                .statusCode(HttpStatus.SERVICE_UNAVAILABLE.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.SERVICE_UNAVAILABLE);
    }
}