package ua.lysenko.banking.transaction.models;

import lombok.Builder;
import lombok.Data;
import ua.lysenko.banking.transaction.enums.TransactionType;

@Data
@Builder
public class TransactionValidationModel {
    private String cardNumber;
    private String destinationCardNumber;
    private TransactionType transactionType;

    private Long requestUserId;
    private Long persistUserId;


}
