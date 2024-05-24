package ua.lysenko.banking.utils.validators.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.exception.IdenticalCardTransactionException;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.AbstractTransactionValidator;

@Slf4j
@Component
public class IdenticalCardTransferTransactionValidator extends AbstractTransactionValidator {


    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (transaction.getTransactionType().equals(TransactionType.TRANSFER) &&
                transaction.getCardNumber().equals(transaction.getDestinationCardNumber())) {
            throw new IdenticalCardTransactionException(ExceptionKeys.CARDS_CAN_NOT_BE_IDENTICAL.getMessage());
        }
        next(transaction, result);
    }
}
