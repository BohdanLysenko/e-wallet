package ua.lysenko.banking.service;

import common.grpc.users.*;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.exception.JwtExpiredException;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;

@Service
@Slf4j
public class CommonBankingServiceGrpc {
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;


    public CommonBankingServiceGrpc(UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub) {
        this.userServiceBlockingStub = userServiceBlockingStub;
    }

    public void sendSuspiciousUserEvent(TransactionValidationResult transaction) {
        UserSuspiciousRequest request = UserSuspiciousRequest.newBuilder()
                .setId(transaction.getRequestUserId())
                .build();
        userServiceBlockingStub.updateUserSuspiciousActivity(request);
        log.warn(String.format(
                ExceptionKeys.SUSPICIOUS_AMOUNT_OF_TRANSACTIONS.getMessage(),
                transaction.getRequestUserId()));
    }

    public void sendBlockedUserEvent(TransactionValidationResult transaction) {
        UserDisabledRequest request = UserDisabledRequest.newBuilder()
                .setId(transaction.getRequestUserId())
                .build();
        userServiceBlockingStub.updateUserTransactionBlocked(request);
        log.warn(String.format(
                ExceptionKeys.BLOCKED_AMOUNT_OF_TRANSACTIONS.getMessage(),
                transaction.getRequestUserId()));
    }

    public UserMessage getCurrentUser(String token) {
        UserTokenRequest userTokenRequest = UserTokenRequest.newBuilder()
                .setToken(token)
                .build();
        UserMessage userMessage;
        try {
            userMessage = userServiceBlockingStub.getUserDetails(userTokenRequest).getResp();
        } catch (StatusRuntimeException exception) {
            if (exception.getStatus().equals(Status.UNAUTHENTICATED)) {
                throw new JwtExpiredException(ExceptionKeys.JWT_EXPIRED.getMessage());
            }
            if (exception.getStatus().equals(Status.INVALID_ARGUMENT)) {
                throw new MalformedJwtException(ExceptionKeys.JWT_MALFORMED.getMessage());
            }
            throw exception;
        }
        return userMessage;
    }
}
