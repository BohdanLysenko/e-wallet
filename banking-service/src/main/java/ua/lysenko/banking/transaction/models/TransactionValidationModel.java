package ua.lysenko.banking.transaction.models;

import lombok.Builder;
import lombok.Data;
import ua.lysenko.banking.transaction.enums.TransactionType;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionValidationModel {

    private boolean isUserTransactionBlocked;
    private boolean isSuspiciousActivityDetected;
    private String cardNumber;
    private String destinationCardNumber;
    private TransactionType transactionType;

    private Long requestUserId;
    private Long persistUserId;
    private BigDecimal amount;

    private String errorMsg;


}
