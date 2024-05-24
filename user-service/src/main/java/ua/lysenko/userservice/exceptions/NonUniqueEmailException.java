package ua.lysenko.userservice.exceptions;

public class NonUniqueEmailException extends RuntimeException {
    public NonUniqueEmailException(String message) {
        super(message);
    }
}