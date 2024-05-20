package ua.lysenko.banking.card.textresources;

import lombok.Getter;

@Getter
public enum ExceptionKeys {

    ACCOUNT_IS_LOCKED("The account is locked. Please, contact system administrator");
    private final String message;

    ExceptionKeys(String message) {
        this.message = message;
    }
}
