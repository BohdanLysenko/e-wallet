package ua.lysenko.userserivce.exceptions.handlers;

import jakarta.validation.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.userserivce.exceptions.NonUniqueEmailException;
import ua.lysenko.userserivce.textresources.ExceptionKeys;
import ua.lysenko.userserivce.exceptions.Responses.ApiExceptionModel;
import ua.lysenko.userserivce.exceptions.userexceptions.InvalidPasswordException;
import ua.lysenko.userserivce.exceptions.userexceptions.UserNotFoundException;
import ua.lysenko.userserivce.shared.Utils;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiExceptionModel> handleUserServiceNotFoundException(UserNotFoundException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiExceptionModel> handleInvalidPasswordException(InvalidPasswordException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiExceptionModel> handleConstraintViolationException(ConstraintViolationException e) {
        ApiExceptionModel apiExceptionModel = new ApiExceptionModel();
        StringBuilder errorMessageBuilder = new StringBuilder();
        e.getConstraintViolations().forEach(violation -> {
            String errorMessage = violation.getMessage();
            if (errorMessage.equals("invalid_email")) {
                Utils.appendToMessage(errorMessageBuilder, ExceptionKeys.EMAIL_IS_INVALID.getMessage());
            } else if (errorMessage.equals("invalid_name")) {
                Utils.appendToMessage(errorMessageBuilder, ExceptionKeys.NAME_IS_INVALID.getMessage());
            }
            else if (errorMessage.equals("invalid_password")) {
                Utils.appendToMessage(errorMessageBuilder, ExceptionKeys.PASSWORD_IS_INVALID.getMessage());
            }
        });
        apiExceptionModel.setMessage(errorMessageBuilder.toString());
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NonUniqueEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiExceptionModel> handleNonUniqueEmailException(NonUniqueEmailException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
    }
}