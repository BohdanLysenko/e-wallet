package ua.lysenko.banking.exception.userexceptions;

public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException(String message) {
        super(message);
    }
}
