package ua.lysenko.banking.utils.validators;

import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;

public interface TransactionValidator {
    void setNext(TransactionValidator next);

    void validate(TransactionValidationModel transactionValidationModel, TransactionValidationResult result);
}
