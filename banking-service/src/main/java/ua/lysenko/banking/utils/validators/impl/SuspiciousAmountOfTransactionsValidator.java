package ua.lysenko.banking.utils.validators.impl;

import common.grpc.users.UserDisabledRequest;
import common.grpc.users.UserServiceGrpc;
import common.grpc.users.UserSuspiciousRequest;
import common.grpc.users.UserTokenRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.transaction.repository.TransactionRepository;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.AbstractTransactionValidator;

@Slf4j
@Component
public class SuspiciousAmountOfTransactionsValidator extends AbstractTransactionValidator {

    private final TransactionRepository transactionRepository;
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @Value("${transaction.limit.amount.suspicious}")
    private int maxAmountOfSuspiciousTransactions;

    public SuspiciousAmountOfTransactionsValidator(TransactionRepository transactionRepository, UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub) {
        this.transactionRepository = transactionRepository;
        this.userServiceBlockingStub = userServiceBlockingStub;
    }


    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (!transaction.isSuspiciousActivityDetected()) {
            int currentAmountOfTransactions = transactionRepository
                    .countTransactionForLastHourByUserId(transaction.getRequestUserId());
            if ((currentAmountOfTransactions + 1) >= maxAmountOfSuspiciousTransactions) {
                log.warn(String.format(
                        ExceptionKeys.SUSPICIOUS_AMOUNT_OF_TRANSACTIONS.getMessage(),
                        transaction.getRequestUserId()));
                UserSuspiciousRequest request = UserSuspiciousRequest.newBuilder()
                        .setId(transaction.getRequestUserId())
                        .build();
                userServiceBlockingStub.updateUserSuspiciousActivity(request);
            }
        }
        next(transaction, result);
    }
}
