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
public class SuspiciousTransactionValidator extends AbstractTransactionValidator {

    private final BigDecimal suspiciousTransactionAmount;

    public SuspiciousTransactionValidator(@Value("${transaction.limit.suspicious}")
                                          BigDecimal suspiciousTransactionAmount) {
        this.suspiciousTransactionAmount = suspiciousTransactionAmount;
    }


    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (transaction.getAmount().compareTo(suspiciousTransactionAmount) > 0) {
            log.warn(ExceptionKeys.SUSPICIOUS_TRANSACTION.getMessage());
            result.setSuspicious(true);
        }
        next(transaction, result);
    }
}
