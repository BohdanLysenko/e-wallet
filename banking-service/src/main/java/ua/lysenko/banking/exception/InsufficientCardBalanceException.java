package ua.lysenko.banking.exception;

public class InsufficientCardBalanceException extends RuntimeException {
    public InsufficientCardBalanceException(String message) {
        super(message);
    }
}
