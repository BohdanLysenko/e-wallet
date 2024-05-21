package ua.lysenko.banking.utils.textresources;

import lombok.Getter;

@Getter
public enum ExceptionKeys {

    ACCOUNT_IS_LOCKED("The account is locked. Please, contact system administrator"),
    CARD_NUMBER_NOT_FOUND("Card: '%s' is not found"),
    CARD_ID_NOT_FOUND("Card is not found"),
    TRANSACTION_UNAUTHORIZED("Invalid user: You are not authorized to perform this transaction"),
    SINGLE_TRANSACTION_LIMIT_EXCEEDED("The transaction exceeds single transaction limit");
    private final String message;

    ExceptionKeys(String message) {
        this.message = message;
    }
}
