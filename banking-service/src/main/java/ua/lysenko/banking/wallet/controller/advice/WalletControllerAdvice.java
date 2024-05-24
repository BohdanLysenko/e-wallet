package ua.lysenko.banking.wallet.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.banking.exception.Response.ApiExceptionModel;
import ua.lysenko.banking.exception.WalletNotFoundException;

@RestControllerAdvice
public class WalletControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<ApiExceptionModel> handleCardNotFoundException(WalletNotFoundException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.NOT_FOUND);
    }
}
