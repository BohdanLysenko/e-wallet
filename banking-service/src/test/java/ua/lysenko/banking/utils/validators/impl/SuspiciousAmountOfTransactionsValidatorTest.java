package ua.lysenko.banking.utils.validators.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.transaction.repository.TransactionRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SuspiciousAmountOfTransactionsValidatorTest {

    public static final long REQUEST_USER_ID = 1L;
    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionValidationModel transaction;

    private SuspiciousAmountOfTransactionsValidator validator;

    @BeforeEach
    void setUp() {
        validator = new SuspiciousAmountOfTransactionsValidator(transactionRepository);
        ReflectionTestUtils.setField(validator, "maxAmountOfSuspiciousTransactions", 5);
        when(transaction.isSuspiciousActivityDetected()).thenReturn(false);
        when(transaction.getRequestUserId()).thenReturn(REQUEST_USER_ID);
    }


    @Test
    @DisplayName("TransactionValidationResult should mark user blocked for next transactions")
    void validateUserSuspicious() {
        TransactionValidationResult result = buildTransactionValidationResult();

        when(transactionRepository.countTransactionForLastHourByUserId(anyLong())).thenReturn(4);

        validator.validate(transaction, result);

        assertTrue(result.isUserShouldBeMarkedSuspicious());
        verify(transactionRepository).countTransactionForLastHourByUserId(eq(REQUEST_USER_ID));
    }

    @Test
    @DisplayName("TransactionValidationResult should not mark user blocked for next transactions")
    void validateUserNotSuspicious() {
        TransactionValidationResult result = buildTransactionValidationResult();

        when(transactionRepository.countTransactionForLastHourByUserId(anyLong())).thenReturn(1);

        validator.validate(transaction, result);

        assertFalse(result.isUserShouldBeMarkedSuspicious());
        verify(transactionRepository).countTransactionForLastHourByUserId(eq(REQUEST_USER_ID));
    }

    private static TransactionValidationResult buildTransactionValidationResult() {
        return TransactionValidationResult.builder()
                .isSuspicious(false)
                .isValid(true)
                .build();
    }

}