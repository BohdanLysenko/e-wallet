package ua.lysenko.userservice.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.userservice.exceptions.*;
import ua.lysenko.userservice.exceptions.Responses.ApiExceptionModel;
import ua.lysenko.userservice.textresources.ExceptionKeys;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiExceptionModel> handleUserServiceNotFoundException(UserNotFoundException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ApiExceptionModel> handleInvalidPasswordException(InvalidPasswordException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NonUniqueEmailException.class)
    public ResponseEntity<ApiExceptionModel> handleNonUniqueEmailException(NonUniqueEmailException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiExceptionModel> handleBadCredentialsException(BadCredentialsException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(ExceptionKeys.INVALID_CREDENTIALS.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<ApiExceptionModel> handleServiceUnavailableException(ServiceUnavailableException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(ExceptionKeys.SERVICE_UNAVAILABLE.getMessage())
                .statusCode(HttpStatus.SERVICE_UNAVAILABLE.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<ApiExceptionModel> handleWalletNotFoundException(WalletNotFoundException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(ExceptionKeys.NO_ACTIVE_WALLETS.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }
}