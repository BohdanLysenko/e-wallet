package ua.lysenko.banking.transaction.events;

import ua.lysenko.banking.transaction.models.TransactionValidationModel;

public class BlockedUserEvent {
    private final TransactionValidationModel transactionValidationModel;

    public BlockedUserEvent(TransactionValidationModel transactionValidationModel){
        this.transactionValidationModel = transactionValidationModel;
    }

    public TransactionValidationModel getTransactionValidationModel() {
        return transactionValidationModel;
    }
}