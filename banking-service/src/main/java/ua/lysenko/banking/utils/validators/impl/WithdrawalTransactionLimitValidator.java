package ua.lysenko.banking.utils.validators.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.transaction.service.implementation.WithdrawalTransactionService;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.AbstractTransactionValidator;

@Slf4j
@Component
public class WithdrawalTransactionLimitValidator extends AbstractTransactionValidator {

    private final WithdrawalTransactionService withdrawalTransactionService;

    private final CardService cardService;

    public WithdrawalTransactionLimitValidator(
            WithdrawalTransactionService withdrawalTransactionService,
            CardService cardService) {
        this.withdrawalTransactionService = withdrawalTransactionService;
        this.cardService = cardService;
    }


    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (transaction.getTransactionType().equals(TransactionType.WITHDRAWAL)) {
            Long cardId = cardService.getByCardNumber(transaction.getCardNumber()).getId();
            if (withdrawalTransactionService.isWithdrawalLimitExceededByCard(cardId, transaction.getAmount())) {
                String errorMsg = String.format(
                        ExceptionKeys.DAILY_WITHDRAWAL_LIMIT_EXCEEDED.getMessage(),
                        transaction.getCardNumber());
                log.warn(errorMsg);
                result.setValid(false);
                result.getErrorMsg().add(errorMsg);
            }
        }
        next(transaction, result);
    }
}
