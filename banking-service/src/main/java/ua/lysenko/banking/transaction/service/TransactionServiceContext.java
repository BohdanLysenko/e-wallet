package ua.lysenko.banking.transaction.service;

import common.grpc.Users.UserMessage;
import common.grpc.Users.UserServiceGrpc;
import common.grpc.Users.UserTokenRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.exception.AccountIsLockedException;
import ua.lysenko.banking.exception.TransactionUnauthorizedException;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.TransactionSenderValidator;
import ua.lysenko.banking.utils.validators.UserDetailsResponseValidator;

import java.util.Map;

@AllArgsConstructor
@Slf4j
@Service
public class TransactionServiceContext {
    private final Map<TransactionType, TransactionService> processTransactionByType;
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;
    private final UserDetailsResponseValidator userDetailsResponseValidator;
    private final TransactionSenderValidator transactionSenderValidator;
    private final CardService cardService;

    public TransactionDTO processTransaction(String authorizationHeader, TransactionDTO transaction, TransactionType transactionType) {
        UserMessage user = getCurrentUser(authorizationHeader);
        if (!userDetailsResponseValidator.isValid(user)) {
            throw new AccountIsLockedException(ExceptionKeys.ACCOUNT_IS_LOCKED.getMessage());
        }
        TransactionValidationModel transactionValidationRequest = getTransactionValidationRequestModel(transaction, transactionType, user);
        if (!transactionSenderValidator.isValid(transactionValidationRequest)) {
            throw new TransactionUnauthorizedException(ExceptionKeys.TRANSACTION_IS_UNAUTHORIZED.getMessage());
        }
        TransactionService transactionService = processTransactionByType.get(transactionType);
        if (transactionService != null) {

            return transactionService.processTransaction(transaction);
        }
        //ToDo
        else throw new RuntimeException("test");
    }

    public TransactionValidationModel getTransactionValidationRequestModel(TransactionDTO transaction, TransactionType transactionType, UserMessage user) {
        return TransactionValidationModel.builder()
                .transactionType(transactionType)
                .destinationCardNumber(transaction.getDestinationCardNumber())
                .cardNumber(transaction.getCardNumber())
                .requestUserId(user.getId())
                .persistUserId(cardService.getByCardNumber(transaction.getCardNumber()).getWallet().getUserId())
                .build();
    }

    private UserMessage getCurrentUser(String token) {
        UserTokenRequest userTokenRequest = UserTokenRequest.newBuilder()
                .setToken(token)
                .build();
        return userServiceBlockingStub.getUserDetails(userTokenRequest).getResp();
    }
}
