package ua.lysenko.banking.transaction.service;

import common.grpc.users.UserMessage;
import common.grpc.users.UserServiceGrpc;
import common.grpc.users.UserTokenRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.Mappers.TransactionContextMapper;
import ua.lysenko.banking.utils.validators.impl.TransactionValidatorChain;

import java.util.Map;

@Slf4j
@Service
public class TransactionServiceContext {
    private final Map<TransactionType, TransactionService> processTransactionByType;
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;
    private final CardService cardService;
    private final TransactionValidatorChain validatorChain;
    private final TransactionContextMapper transactionMapper;

    public TransactionServiceContext(Map<TransactionType, TransactionService> processTransactionByType,
                                     UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub,
                                     CardService cardService, TransactionValidatorChain validatorChain,
                                     TransactionContextMapper transactionMapper) {
        this.processTransactionByType = processTransactionByType;
        this.userServiceBlockingStub = userServiceBlockingStub;
        this.cardService = cardService;
        this.validatorChain = validatorChain;
        this.transactionMapper = transactionMapper;
    }

    public TransactionDTO processTransaction(String authorizationHeader,
                                             TransactionDTO transaction,
                                             TransactionType transactionType) {
        TransactionValidationResult validatedTransaction = validateTransaction(authorizationHeader,
                transaction, transactionType);
        transaction = transactionMapper.updateTransactionDTO(validatedTransaction, transaction);
        TransactionService transactionService = processTransactionByType.get(transactionType);
        return transactionService.processTransaction(transaction);
    }

    private UserMessage getCurrentUser(String token) {
        UserTokenRequest userTokenRequest = UserTokenRequest.newBuilder()
                .setToken(token)
                .build();
        return userServiceBlockingStub.getUserDetails(userTokenRequest).getResp();
    }


    private TransactionValidationResult validateTransaction(String authorizationHeader,
                                                            TransactionDTO transaction,
                                                            TransactionType transactionType) {
        UserMessage user = getCurrentUser(authorizationHeader);
        TransactionValidationModel transactionValidationModel = getTransactionValidationModel(transaction,
                transactionType, user);
        TransactionValidationResult result = TransactionValidationResult.builder()
                .isValid(true)
                .isSuspicious(false)
                .build();
        validatorChain.validate(transactionValidationModel, result);
        return result;
    }

    private TransactionValidationModel getTransactionValidationModel(TransactionDTO transaction,
                                                                     TransactionType transactionType,
                                                                     UserMessage user) {
        return TransactionValidationModel.builder()
                .transactionType(transactionType)
                .isUserTransactionBlocked(user.getTransactionBlocked())
                .destinationCardNumber(transaction.getDestinationCardNumber())
                .cardNumber(transaction.getCardNumber())
                .requestUserId(user.getId())
                .persistUserId(cardService.getByCardNumber(transaction.getCardNumber()).getWallet().getUserId())
                .amount(transaction.getAmount())
                .isSuspiciousActivityDetected(user.getSuspiciousActivityDetected())
                .build();
    }

}
