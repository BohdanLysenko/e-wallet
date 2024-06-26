package ua.lysenko.banking.controller.advice;


import io.grpc.StatusRuntimeException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.banking.exception.*;
import ua.lysenko.banking.exception.Response.ApiExceptionModel;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;

@RestControllerAdvice
public class CommonBankingControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<ApiExceptionModel> handleStatusRunTimeException(StatusRuntimeException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(ExceptionKeys.SERVICE_UNAVAILABLE.getMessage())
                .statusCode(HttpStatus.SERVICE_UNAVAILABLE.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.SERVICE_UNAVAILABLE);
    }
    @ExceptionHandler(JwtExpiredException.class)
    public ResponseEntity<ApiExceptionModel> handleStatusRunTimeException(JwtExpiredException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ApiExceptionModel> handleStatusRunTimeException(MalformedJwtException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }

}