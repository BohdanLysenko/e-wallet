package ua.lysenko.banking.transaction.DTO;

import lombok.*;
import ua.lysenko.banking.transaction.enums.TransactionType;

import java.math.BigDecimal;

@Data
public class TransactionDTO {

    protected Long id;
    protected String transactionUUID;
    protected BigDecimal amount;
    protected boolean isSuspicious;
    protected Long cardId;

    protected String cardNumber;
    protected Long merchantId;
    protected Long destinationCardId;
    protected String destinationCardNumber;
    protected boolean isSuccessful;

    protected TransactionType transactionType;

}