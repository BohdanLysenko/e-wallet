package ua.lysenko.userserivce.exceptions;

public class NonUniqueEmailException extends RuntimeException {
    public NonUniqueEmailException(String message) {
        super(message);
    }
}