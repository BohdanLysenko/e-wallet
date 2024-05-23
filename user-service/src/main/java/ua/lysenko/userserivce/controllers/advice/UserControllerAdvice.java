package ua.lysenko.userserivce.controllers.advice;

import io.grpc.StatusRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.userserivce.exceptions.NonUniqueEmailException;
import ua.lysenko.userserivce.exceptions.Responses.ApiExceptionModel;
import ua.lysenko.userserivce.exceptions.userexceptions.InvalidPasswordException;
import ua.lysenko.userserivce.exceptions.userexceptions.UserNotFoundException;
import ua.lysenko.userserivce.textresources.ExceptionKeys;

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

    @ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<ApiExceptionModel> handleStatusRunTimeException(StatusRuntimeException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(ExceptionKeys.SERVICE_UNAVAILABLE.getMessage())
                .statusCode(HttpStatus.SERVICE_UNAVAILABLE.value())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.SERVICE_UNAVAILABLE);
    }
}