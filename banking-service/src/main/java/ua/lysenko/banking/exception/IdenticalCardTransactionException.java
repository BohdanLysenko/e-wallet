package ua.lysenko.banking.exception;

public class IdenticalCardTransactionException extends RuntimeException {
    public IdenticalCardTransactionException(String message) {
        super(message);
    }
}
