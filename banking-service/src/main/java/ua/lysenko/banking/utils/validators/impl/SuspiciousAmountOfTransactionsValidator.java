package ua.lysenko.banking.utils.validators.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.transaction.repository.TransactionRepository;
import ua.lysenko.banking.utils.validators.AbstractTransactionValidator;

@Slf4j
@Component
public class SuspiciousAmountOfTransactionsValidator extends AbstractTransactionValidator {

    private final TransactionRepository transactionRepository;

    @Value("${transaction.limit.amount.suspicious}")
    private int maxAmountOfSuspiciousTransactions;

    public SuspiciousAmountOfTransactionsValidator(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (!transaction.isSuspiciousActivityDetected()) {
            int currentAmountOfTransactions = transactionRepository
                    .countTransactionForLastHourByUserId(transaction.getRequestUserId());
            if ((currentAmountOfTransactions + 1) >= maxAmountOfSuspiciousTransactions) {
                result.setUserShouldBeMarkedSuspicious(true);
            }
        }
        next(transaction, result);
    }
}
