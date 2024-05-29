package ua.lysenko.banking.transaction.service;

import common.grpc.users.UserMessage;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.service.CommonBankingServiceGrpc;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.mappers.TransactionContextMapper;
import ua.lysenko.banking.utils.validators.impl.TransactionValidatorChain;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class TransactionServiceContext {
    private final Map<TransactionType, TransactionService> processTransactionByType;
    private final CardService cardService;
    private final TransactionValidatorChain validatorChain;
    private final TransactionContextMapper transactionMapper;
    private final CommonBankingServiceGrpc commonBankingServiceService;

    public TransactionServiceContext(Map<TransactionType, TransactionService> processTransactionByType,
                                     CardService cardService, TransactionValidatorChain validatorChain,
                                     TransactionContextMapper transactionMapper,
                                     CommonBankingServiceGrpc commonBankingServiceService) {
        this.processTransactionByType = processTransactionByType;
        this.cardService = cardService;
        this.validatorChain = validatorChain;
        this.transactionMapper = transactionMapper;
        this.commonBankingServiceService = commonBankingServiceService;
    }

    public TransactionDTO processTransaction(String authorizationHeader,
                                             TransactionDTO transaction,
                                             TransactionType transactionType) {
        TransactionValidationResult validatedTransaction = validateTransaction(authorizationHeader,
                transaction, transactionType);
        transaction = transactionMapper.updateTransactionDTO(validatedTransaction, transaction);
        TransactionService transactionService = processTransactionByType.get(transactionType);
        TransactionDTO transactionDTO = transactionService.processTransaction(transaction);
        updateUser(validatedTransaction);
        transactionDTO.setErrorMsgs(validatedTransaction.getErrorMsg());
        return transactionDTO;
    }


    private TransactionValidationResult validateTransaction(String authorizationHeader,
                                                            TransactionDTO transaction,
                                                            TransactionType transactionType) {
        UserMessage user = commonBankingServiceService.getCurrentUser(authorizationHeader);
        TransactionValidationModel transactionValidationModel = getTransactionValidationModel(transaction,
                transactionType, user);
        TransactionValidationResult result = TransactionValidationResult.builder()
                .isValid(true)
                .isSuspicious(false)
                .userShouldBeMarkedSuspicious(false)
                .userShouldBeTransactionBlocked(false)
                .errorMsg(new ArrayList<>())
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
                .persistUserId(cardService.findByCardNumber(transaction.getCardNumber()).getWallet().getUserId())
                .amount(transaction.getAmount())
                .isSuspiciousActivityDetected(user.getSuspiciousActivityDetected())
                .build();
    }


    private void updateUser(TransactionValidationResult validatedTransaction) {
        if (validatedTransaction.isUserShouldBeMarkedSuspicious()) {
            commonBankingServiceService.sendSuspiciousUserEvent(validatedTransaction);
        }
        if (validatedTransaction.isUserShouldBeTransactionBlocked()) {
            commonBankingServiceService.sendBlockedUserEvent(validatedTransaction);
        }
    }
}
