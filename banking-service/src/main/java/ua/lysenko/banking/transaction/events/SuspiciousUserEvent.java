package ua.lysenko.banking.transaction.events;

import ua.lysenko.banking.transaction.models.TransactionValidationModel;

public class SuspiciousUserEvent {
    private final TransactionValidationModel transactionValidationModel;

    public SuspiciousUserEvent(TransactionValidationModel transactionValidationModel){
        this.transactionValidationModel = transactionValidationModel;
    }

    public TransactionValidationModel getTransactionValidationModel() {
        return transactionValidationModel;
    }
}