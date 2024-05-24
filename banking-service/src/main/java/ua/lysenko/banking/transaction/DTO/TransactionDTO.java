package ua.lysenko.banking.transaction.DTO;

import lombok.Builder;
import lombok.Data;
import ua.lysenko.banking.transaction.enums.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class TransactionDTO {

    protected Long id;
    protected String transactionUUID;

    protected BigDecimal amount;
    protected BigDecimal balance;

    protected boolean isSuspicious;

    protected Long cardId;

    protected String cardNumber;
    protected Long merchantId;
    protected Long destinationCardId;
    protected String destinationCardNumber;

    protected boolean isSuccessful;
    protected TransactionType transactionType;

    protected Instant createdDate;
    private List<String> errorMsgs;

}