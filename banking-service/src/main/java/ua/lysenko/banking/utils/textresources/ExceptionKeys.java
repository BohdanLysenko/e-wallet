package ua.lysenko.banking.utils.textresources;

import lombok.Getter;

@Getter
public enum ExceptionKeys {

    ACCOUNT_IS_LOCKED("Transaction are disabled for the account. Please, contact system administrator"),
    CARD_NUMBER_NOT_FOUND("Card: %s is not found"),
    CARD_NOT_FOUND("Card is not found"),
    WALLET_NOT_FOUND("Wallet is not found"),
    TRANSACTION_UNAUTHORIZED("Invalid user: You are not authorized to perform this transaction"),
    SINGLE_TRANSACTION_LIMIT_EXCEEDED("The transaction exceeds single transaction limit"),
    INSUFFICIENT_CARD_BALANCE_EXCEPTION("The transaction of %sEUR exceeds current balance"),
    DAILY_WITHDRAWAL_LIMIT_EXCEEDED("Daily withdrawal limit is exceeded for card %s"),
    SUSPICIOUS_TRANSACTION("Transaction is marked as suspicious"),
    SUSPICIOUS_AMOUNT_OF_TRANSACTIONS("User %s is marked as suspicious"),
    BLOCKED_AMOUNT_OF_TRANSACTIONS("User %s had exceeded amount of hourly transactions and is disabled"),
    SERVICE_UNAVAILABLE("Service is temporarily unavailable. Please try again later"),
    UNAUTHORIZED_ACCESS("Sorry, you're not authorized to perform this action"),
    CARDS_CAN_NOT_BE_IDENTICAL("Destination card can not be the same as sender card"),
    JWT_EXPIRED("Token is expired"),
    JWT_MALFORMED("Token is malformed");
    private final String message;

    ExceptionKeys(String message) {
        this.message = message;
    }
}
