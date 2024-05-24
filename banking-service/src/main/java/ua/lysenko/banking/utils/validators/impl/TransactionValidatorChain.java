package ua.lysenko.banking.utils.validators.impl;

import org.springframework.stereotype.Component;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.validators.TransactionValidator;


@Component
public class TransactionValidatorChain {
    private final TransactionValidator chain;

    public TransactionValidatorChain(UserTransactionBlockedValidator userEnabledValidator,
                                     TransactionSenderValidator transactionSenderValidator,
                                     TransactionAmountLimitValidator transactionAmountLimitValidator,
                                     IdenticalCardTransferTransactionValidator identicalCardTransferTransactionValidator,
                                     BalanceExceededTransactionValidator balanceExceededTransactionValidator,
                                     WithdrawalTransactionLimitValidator withdrawalTransactionLimitValidator,
                                     SuspiciousAmountOfTransactionsValidator suspiciousAmountOfTransactionsValidator,
                                     SuspiciousTransactionValidator suspiciousTransactionValidator,
                                     BlockedAmountOfTransactionsValidator blockedAmountOfTransactionsValidator) {
        chain = userEnabledValidator;
        userEnabledValidator.setNext(identicalCardTransferTransactionValidator);
        identicalCardTransferTransactionValidator.setNext(transactionSenderValidator);
        transactionSenderValidator.setNext(transactionAmountLimitValidator);
        transactionAmountLimitValidator.setNext(balanceExceededTransactionValidator);
        balanceExceededTransactionValidator.setNext(withdrawalTransactionLimitValidator);
        withdrawalTransactionLimitValidator.setNext(suspiciousAmountOfTransactionsValidator);
        suspiciousAmountOfTransactionsValidator.setNext(suspiciousTransactionValidator);
        suspiciousTransactionValidator.setNext(blockedAmountOfTransactionsValidator);
    }

    public void validate(TransactionValidationModel transactionValidationModel, TransactionValidationResult result) {
        chain.validate(transactionValidationModel, result);
    }
}