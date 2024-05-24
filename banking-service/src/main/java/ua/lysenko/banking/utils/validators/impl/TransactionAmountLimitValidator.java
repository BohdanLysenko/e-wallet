package ua.lysenko.banking.utils.validators.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.AbstractTransactionValidator;

import java.math.BigDecimal;

@Slf4j
@Component
public class TransactionAmountLimitValidator extends AbstractTransactionValidator {

    private final BigDecimal singleTransactionAmountLimit;

    public TransactionAmountLimitValidator(@Value("${transaction.limit.single}")
                                           BigDecimal singleTransactionAmountLimit) {
        this.singleTransactionAmountLimit = singleTransactionAmountLimit;
    }

    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (transaction.getAmount().compareTo(singleTransactionAmountLimit) > 0) {
            log.warn(ExceptionKeys.SINGLE_TRANSACTION_LIMIT_EXCEEDED.getMessage());
            result.setValid(false);
            result.getErrorMsg().add(ExceptionKeys.SINGLE_TRANSACTION_LIMIT_EXCEEDED.getMessage());
        }
        next(transaction, result);
    }
}
