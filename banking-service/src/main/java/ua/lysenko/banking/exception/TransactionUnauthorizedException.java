package ua.lysenko.banking.exception;

public class TransactionUnauthorizedException extends RuntimeException {
    public TransactionUnauthorizedException(String message) {
        super(message);
    }
}
