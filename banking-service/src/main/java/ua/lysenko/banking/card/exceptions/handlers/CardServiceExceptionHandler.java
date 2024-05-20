package ua.lysenko.banking.card.exceptions.handlers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lysenko.banking.exception.Responses.ApiExceptionModel;
import ua.lysenko.banking.exception.userexceptions.AccountIsLockedException;

@ControllerAdvice
public class CardServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountIsLockedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ApiExceptionModel> handleUserServiceNotFoundException(AccountIsLockedException e) {
        ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiExceptionModel, HttpStatus.FORBIDDEN);
    }
}