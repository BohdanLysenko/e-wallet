package ua.lysenko.banking.utils.validators.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.transaction.service.implementation.WithdrawalTransactionService;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WithdrawalTransactionLimitValidatorTest {

    public static final long CARD_ID = 1L;
    public static final String CARD_NUMBER = "12312312";
    public static final BigDecimal TRANSACTION_AMOUNT = BigDecimal.TEN;
    @Mock
    private CardService cardService;

    @Mock
    private TransactionValidationModel transaction;
    @Mock
    private WithdrawalTransactionService withdrawalTransactionService;

    private WithdrawalTransactionLimitValidator validator;

    @BeforeEach
    void setUp() {
        CardDTO card = buildCardDTO();
        validator = new WithdrawalTransactionLimitValidator(withdrawalTransactionService, cardService);
        when(transaction.getTransactionType()).thenReturn(TransactionType.WITHDRAWAL);
        when(transaction.getCardNumber()).thenReturn(CARD_NUMBER);
        when(cardService.getByCardNumber(CARD_NUMBER)).thenReturn(card);
        when(transaction.getAmount()).thenReturn(TRANSACTION_AMOUNT);
    }


    @Test
    @DisplayName("TransactionValidationResult should be marked invalid when withdrawal limit is exceeded")
    void validateWithdrawalLimitExceeded() {
        TransactionValidationResult result = buildTransactionValidationResult();

        when(withdrawalTransactionService.isWithdrawalLimitExceededByCard(CARD_ID,
                transaction.getAmount())).thenReturn(true);

        validator.validate(transaction, result);

        assertFalse(result.isValid());
        assertFalse(result.getErrorMsg().isEmpty());
    }

    @Test
    @DisplayName("TransactionValidationResult should remain valid when withdrawal limit is not exceeded")
    void validateWithdrawalLimitNotExceeded() {
        TransactionValidationResult result = buildTransactionValidationResult();

        when(withdrawalTransactionService.isWithdrawalLimitExceededByCard(CARD_ID,
                transaction.getAmount())).thenReturn(false);

        validator.validate(transaction, result);

        assertTrue(result.isValid());
        assertTrue(result.getErrorMsg().isEmpty());
    }

    private static TransactionValidationResult buildTransactionValidationResult() {
        return TransactionValidationResult.builder()
                .isSuspicious(false)
                .isValid(true)
                .errorMsg(new ArrayList<>())
                .build();
    }

    private static CardDTO buildCardDTO() {
        return CardDTO.builder()
                .id(CARD_ID)
                .cardNumber(CARD_NUMBER)
                .balance(BigDecimal.valueOf(10000))
                .build();
    }

}