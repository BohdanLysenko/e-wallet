package ua.lysenko.banking.utils.validators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.service.implementation.WithdrawalTransactionService;
import ua.lysenko.banking.validators.BaseValidator;

import java.math.BigDecimal;

@Component
public class WithdrawalTransactionLimitValidator implements BaseValidator<TransactionValidationModel> {

    private final BigDecimal withdrawalDailyLimit;
    private final WithdrawalTransactionService withdrawalTransactionService;

    private final CardService cardService;


    public WithdrawalTransactionLimitValidator(@Value("${withdrawal.limit.daily}") BigDecimal withdrawalDailyLimit,
                                               WithdrawalTransactionService withdrawalTransactionService,
                                               CardService cardService) {
        this.withdrawalDailyLimit = withdrawalDailyLimit;
        this.withdrawalTransactionService = withdrawalTransactionService;
        this.cardService = cardService;
    }

    @Override
    public boolean isValid(TransactionValidationModel transaction) {
        Long cardId = cardService.getByCardNumber(transaction.getCardNumber()).getId();
        return !withdrawalTransactionService.isWithdrawalLimitExceededByCard(cardId, transaction.getAmount());
    }

}
