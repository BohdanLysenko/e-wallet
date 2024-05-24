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
import ua.lysenko.banking.entity.DepositTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.repository.DepositTransactionRepository;
import ua.lysenko.banking.transaction.service.implementation.DepositTransactionService;
import ua.lysenko.banking.utils.mappers.DepositTransactionMapper;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepositTransactionServiceTest {

    public static final String TRANSACTION_UUID = "b9ef8a70-1d81-4908-9357-0bb3c3a0a7a6";
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(1500);
    public static final long CARD_ID = 1L;
    public static final String CARD_NUMBER = "123123123";
    @Mock
    private CardService cardService;
    @Mock
    private DepositTransactionRepository depositTransactionRepository;

    @Mock
    private DepositTransactionMapper depositTransactionMapper;


    @InjectMocks
    DepositTransactionService depositTransactionService;

    @Test
    @DisplayName("Should process deposit transaction and mark successful")
    void testProcessTransaction() {
        Card card = buildCard();
        TransactionDTO transactionDTO = buildSuccessfulTransactionDTO();
        DepositTransaction depositTransaction = buildSuccessfulDepositTransaction();


        when(cardService.findByCardNumber(transactionDTO.getCardNumber())).thenReturn(card);
        when(cardService.deposit(transactionDTO.getAmount(), card.getId())).thenReturn(true);
        when(depositTransactionRepository.save(any())).thenReturn(depositTransaction);
        when(depositTransactionMapper.updateTransactionDTO(any(), any())).thenReturn(transactionDTO);

        TransactionDTO processedTransaction = depositTransactionService.processTransaction(transactionDTO);

        ArgumentCaptor<DepositTransaction> depositTransactionCaptor =
                ArgumentCaptor.forClass(DepositTransaction.class);
        verify(depositTransactionRepository).save(depositTransactionCaptor.capture());
        DepositTransaction captor = depositTransactionCaptor.getValue();

        assertEquals(captor.getAmount(), processedTransaction.getAmount());
        assertTrue(captor.isSuccessful());
        verify(depositTransactionRepository).save(any());
        assertEquals(processedTransaction.getTransactionType(), TransactionType.DEPOSIT);
    }

    @Test
    @DisplayName("Should process deposit transaction and mark failed")
    void testProcessTransactionFail() {
        Card card = buildCard();
        TransactionDTO transactionDTO = buildFailedTransactionDTO();
        DepositTransaction depositTransaction = buildFailedDepositTransaction();


        when(cardService.findByCardNumber(transactionDTO.getCardNumber())).thenReturn(card);
        when(depositTransactionRepository.save(any())).thenReturn(depositTransaction);
        when(depositTransactionMapper.updateTransactionDTO(any(), any())).thenReturn(transactionDTO);

        TransactionDTO processedTransaction = depositTransactionService.processTransaction(transactionDTO);

        ArgumentCaptor<DepositTransaction> depositTransactionCaptor =
                ArgumentCaptor.forClass(DepositTransaction.class);
        verify(depositTransactionRepository).save(depositTransactionCaptor.capture());
        DepositTransaction captor = depositTransactionCaptor.getValue();

        assertEquals(captor.getAmount(), processedTransaction.getAmount());
        assertFalse(captor.isSuccessful());
        verify(depositTransactionRepository).save(any());
        verify(cardService, never()).deposit(transactionDTO.getAmount(), card.getId());
        assertEquals(processedTransaction.getTransactionType(), TransactionType.DEPOSIT);
    }

    private static DepositTransaction buildSuccessfulDepositTransaction() {
        return DepositTransaction.builder()
                .transactionUUID(UUID.fromString(TRANSACTION_UUID))
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .build();
    }

    private static DepositTransaction buildFailedDepositTransaction() {
        return DepositTransaction.builder()
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
                .transactionUUID(TRANSACTION_UUID)
                .cardNumber(CARD_NUMBER)
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .isSuspicious(false)
                .isSuccessful(true)
                .build();
    }

    private static TransactionDTO buildFailedTransactionDTO() {
        return TransactionDTO.builder()
                .transactionUUID(TRANSACTION_UUID)
                .cardNumber(CARD_NUMBER)
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .isSuspicious(false)
                .isSuccessful(false)
                .build();
    }
}
