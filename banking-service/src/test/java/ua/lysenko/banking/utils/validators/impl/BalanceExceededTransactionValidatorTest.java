package ua.lysenko.banking.utils.validators.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.exception.InsufficientCardBalanceException;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BalanceExceededTransactionValidatorTest {

    public static final long CARD_ID = 1L;
    public static final String CARD_NUMBER = "12312312";
    public static final BigDecimal TRANSACTION_AMOUNT = BigDecimal.TEN;
    @Mock
    private CardService cardService;

    @Mock
    private TransactionValidationModel transaction;

    private BalanceExceededTransactionValidator validator;

    @BeforeEach
    void setUp() {
        validator = new BalanceExceededTransactionValidator(cardService);
        when(transaction.getTransactionType()).thenReturn(TransactionType.TRANSFER);
        when(transaction.getCardNumber()).thenReturn(CARD_NUMBER);
        when(transaction.getAmount()).thenReturn(TRANSACTION_AMOUNT);
        when(cardService.getIdByCardNumber(CARD_NUMBER)).thenReturn(CARD_ID);
    }


    @Test
    @DisplayName("Should throw InsufficientCardBalanceException when balance is exceeded")
    void validateBalanceExceededException() {
        TransactionValidationResult result = buildTransactionValidationResult();
        when(cardService.isBalanceExceeded(TRANSACTION_AMOUNT, CARD_ID)).thenReturn(true);

        assertThrows(InsufficientCardBalanceException.class, () -> validator.validate(transaction, result));

    }
    @Test
    @DisplayName("Should leave transaction valid")
    void validateBalanceNotExceeded() {
        TransactionValidationResult result = buildTransactionValidationResult();
        when(cardService.isBalanceExceeded(TRANSACTION_AMOUNT, CARD_ID)).thenReturn(false);

        validator.validate(transaction, result);

        assertTrue(result.isValid());
    }

    private static TransactionValidationResult buildTransactionValidationResult() {
        return TransactionValidationResult.builder()
                .isSuspicious(false)
                .isValid(true)
                .build();
    }

}