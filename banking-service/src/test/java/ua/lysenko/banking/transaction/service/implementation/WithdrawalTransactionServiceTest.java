package ua.lysenko.banking.transaction.service.implementation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.WithdrawalTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.repository.WithdrawalTransactionRepository;
import ua.lysenko.banking.transaction.service.implementation.WithdrawalTransactionService;
import ua.lysenko.banking.utils.mappers.WithdrawalTransactionMapper;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WithdrawalTransactionServiceTest {

    public static final String TRANSACTION_UUID = "b9ef8a70-1d81-4908-9357-0bb3c3a0a7a6";
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(1500);
    public static final long CARD_ID = 1L;
    public static final String CARD_NUMBER = "123123123";
    @Mock
    private CardService cardService;
    @Mock
    private WithdrawalTransactionRepository withdrawalTransactionRepository;

    @Mock
    private WithdrawalTransactionMapper withdrawalTransactionMapper;


    @InjectMocks
    WithdrawalTransactionService withdrawalTransactionService;

    @Test
    @DisplayName("Should process withdrawal transaction and mark successful")
    void testProcessTransaction() {
        Card card = buildCard();
        TransactionDTO transactionDTO = buildSuccessfulTransactionDTO();
        WithdrawalTransaction withdrawalTransaction = buildSuccessfulWithdrawalTransaction();

        when(cardService.findByCardNumber(transactionDTO.getCardNumber())).thenReturn(card);
        when(cardService.withdraw(transactionDTO.getAmount(), card.getId())).thenReturn(true);
        when(withdrawalTransactionRepository.save(any())).thenReturn(withdrawalTransaction);
        when(withdrawalTransactionMapper.updateTransactionDTO(any(), any())).thenReturn(transactionDTO);

        TransactionDTO processedTransaction = withdrawalTransactionService.processTransaction(transactionDTO);

        ArgumentCaptor<WithdrawalTransaction> withdrawalTransactionCaptor =
                ArgumentCaptor.forClass(WithdrawalTransaction.class);
        verify(withdrawalTransactionRepository).save(withdrawalTransactionCaptor.capture());
        WithdrawalTransaction captor = withdrawalTransactionCaptor.getValue();

        assertEquals(captor.getAmount(), processedTransaction.getAmount());
        assertTrue(captor.isSuccessful());
        verify(withdrawalTransactionRepository).save(any());
        assertEquals(processedTransaction.getTransactionType(), TransactionType.WITHDRAWAL);
    }

    @Test
    @DisplayName("Should process withdrawal transaction and mark failed")
    void testProcessTransactionFail() {
        Card card = buildCard();
        TransactionDTO transactionDTO = buildFailedTransactionDTO();
        WithdrawalTransaction withdrawalTransaction = buildFailedWithdrawalTransaction();


        when(cardService.findByCardNumber(transactionDTO.getCardNumber())).thenReturn(card);
        when(withdrawalTransactionRepository.save(any())).thenReturn(withdrawalTransaction);
        when(withdrawalTransactionMapper.updateTransactionDTO(any(), any())).thenReturn(transactionDTO);

        TransactionDTO processedTransaction = withdrawalTransactionService.processTransaction(transactionDTO);

        ArgumentCaptor<WithdrawalTransaction> withdrawalTransactionCaptor =
                ArgumentCaptor.forClass(WithdrawalTransaction.class);
        verify(withdrawalTransactionRepository).save(withdrawalTransactionCaptor.capture());
        WithdrawalTransaction captor = withdrawalTransactionCaptor.getValue();

        assertEquals(captor.getAmount(), processedTransaction.getAmount());
        assertFalse(captor.isSuccessful());
        verify(withdrawalTransactionRepository).save(any());
        verify(cardService, never()).withdraw(transactionDTO.getAmount(), card.getId());
        assertEquals(processedTransaction.getTransactionType(), TransactionType.WITHDRAWAL);
    }

    private static WithdrawalTransaction buildSuccessfulWithdrawalTransaction() {
        return WithdrawalTransaction.builder()
                .transactionUUID(UUID.fromString(TRANSACTION_UUID))
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .build();
    }

    private static WithdrawalTransaction buildFailedWithdrawalTransaction() {
        return WithdrawalTransaction.builder()
                .transactionUUID(UUID.fromString(TRANSACTION_UUID))
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .build();
    }

    private static Card buildCard() {
        return Card.builder()
                .id(CARD_ID)
                .cardNumber(CARD_NUMBER)
                .balance(BigDecimal.valueOf(10000))
                .build();
    }

    private static TransactionDTO buildSuccessfulTransactionDTO() {
        return TransactionDTO.builder()
                .cardNumber(CARD_NUMBER)
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .isSuspicious(false)
                .isSuccessful(true)
                .build();
    }

    private static TransactionDTO buildFailedTransactionDTO() {
        return TransactionDTO.builder()
                .cardNumber(CARD_NUMBER)
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .isSuspicious(false)
                .isSuccessful(false)
                .build();
    }
}
