package ua.lysenko.banking.utils.validators.impl;

import common.grpc.users.UserDisabledRequest;
import common.grpc.users.UserServiceGrpc;
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
public class BlockedAmountOfTransactionsValidator extends AbstractTransactionValidator {

    private final TransactionRepository transactionRepository;
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @Value("${transaction.limit.amount.blocked}")
    private int maxAmountOfBlockedTransactions;

    public BlockedAmountOfTransactionsValidator(TransactionRepository transactionRepository, UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub) {
        this.transactionRepository = transactionRepository;
        this.userServiceBlockingStub = userServiceBlockingStub;
    }


    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (transaction.isSuspiciousActivityDetected()) {
            int currentAmountOfTransactions = transactionRepository
                    .countTransactionForLastHourByUserId(transaction.getRequestUserId());
            if ((currentAmountOfTransactions + 1) >= maxAmountOfBlockedTransactions) {
                log.warn(String.format(
                        ExceptionKeys.BLOCKED_AMOUNT_OF_TRANSACTIONS.getMessage(),
                        transaction.getRequestUserId()));
                UserDisabledRequest request = UserDisabledRequest.newBuilder()
                        .setId(transaction.getRequestUserId())
                        .build();
                userServiceBlockingStub.updateUserTransactionBlocked(request);
            }
        }
        next(transaction, result);
    }
}
