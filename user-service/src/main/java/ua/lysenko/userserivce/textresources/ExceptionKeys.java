package ua.lysenko.userserivce.textresources;

import lombok.Getter;

@Getter
public enum ExceptionKeys {

    USER_WITH_EMAIL_NOT_FOUND("User with email: '%s' is not found"),
    USER_WITH_ID_NOT_FOUND("User with id: '%s' is not found"),
    JWT_EXPIRED("Your session is expired. Please, sign-in again."),
    AUTHENTICATION_FAILED("Authentication failed"),
    USER_NOT_FOUND("User not found"),
    EMAIL_IS_INVALID("Provided email is invalid"),
    NAME_IS_INVALID("Name shoUld contain at least one non-space character"),
    PASSWORD_IS_INVALID("Password should contain six characters, at least one letter, " +
            "one number and one special character"),
    EMAIL_IS_NOT_UNIQUE("User with the provided email already exists"),
    NO_ACCESS_TO_THE_CONTENT("Sorry, you're not able to access this content"),
    INVALID_CREDENTIALS("Authentication failed. Please check your credentials and try again"),
    SERVICE_UNAVAILABLE("Service is temporarily unavailable. Please try again later"),
    INVALID_PASSWORD_PATTERN("Invalid password upon signup for email %s");
    private final String message;

    ExceptionKeys(String message) {
        this.message = message;
    }
}
