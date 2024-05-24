package ua.lysenko.banking.utils.validators.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.exception.TransactionUnauthorizedException;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.AbstractTransactionValidator;

@Slf4j
@Component
public class TransactionSenderValidator extends AbstractTransactionValidator {
    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (!transaction.getPersistUserId().equals(transaction.getRequestUserId())) {
            log.warn(ExceptionKeys.TRANSACTION_UNAUTHORIZED.getMessage());
            throw new TransactionUnauthorizedException(ExceptionKeys.TRANSACTION_UNAUTHORIZED.getMessage());
        }
        result.setRequestUserId(transaction.getRequestUserId());
        next(transaction, result);
    }
}
