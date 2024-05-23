package ua.lysenko.banking.utils.validators.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.exception.InsufficientCardBalanceException;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.AbstractTransactionValidator;

@Slf4j
@Component
public class BalanceExceededTransactionValidator extends AbstractTransactionValidator {

    private final CardService cardService;

    public BalanceExceededTransactionValidator(CardService cardService) {
        this.cardService = cardService;
    }


    @Override
    public void validate(TransactionValidationModel transaction, TransactionValidationResult result) {
        if (transaction.getTransactionType().equals(TransactionType.WITHDRAWAL) ||
                transaction.getTransactionType().equals(TransactionType.TRANSFER) ||
                transaction.getTransactionType().equals(TransactionType.PAYMENT)
        ) {
            Long cardId = cardService.getIdByCardNumber(transaction.getCardNumber());
            if (cardService.isBalanceExceeded(transaction.getAmount(), cardId)) {
                throw new InsufficientCardBalanceException(
                        String.format(
                                ExceptionKeys.INSUFFICIENT_CARD_BALANCE_EXCEPTION.getMessage(),
                                transaction.getAmount()));
            }
        }
        next(transaction, result);
    }
}
