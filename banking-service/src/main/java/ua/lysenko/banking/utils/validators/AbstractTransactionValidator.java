package ua.lysenko.banking.utils.validators;

import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;

public abstract class AbstractTransactionValidator implements TransactionValidator {
    protected TransactionValidator next;

    @Override
    public void setNext(TransactionValidator next) {
        this.next = next;
    }

    protected void next(TransactionValidationModel transactionValidationModel, TransactionValidationResult result) {
        if (next != null) {
            next.validate(transactionValidationModel, result);
        }
    }
}