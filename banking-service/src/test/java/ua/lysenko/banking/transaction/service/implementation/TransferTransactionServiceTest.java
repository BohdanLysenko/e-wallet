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
import ua.lysenko.banking.entity.TransferTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.repository.TransferTransactionRepository;
import ua.lysenko.banking.transaction.service.implementation.TransferTransactionService;
import ua.lysenko.banking.utils.mappers.TransferTransactionMapper;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferTransactionServiceTest {

    public static final String TRANSACTION_UUID = "b9ef8a70-1d81-4908-9357-0bb3c3a0a7a6";
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(1500);
    public static final long CARD_ID = 1L;
    public static final String CARD_NUMBER = "123123123";
    public static final String DESTINATION_CARD_NUMBER = "454564564";
    public static final long DESTINATION_CARD_ID = 2L;
    @Mock
    private CardService cardService;
    @Mock
    private TransferTransactionRepository transferTransactionRepository;

    @Mock
    private TransferTransactionMapper transferTransactionMapper;


    @InjectMocks
    TransferTransactionService transferTransactionService;

    @Test
    @DisplayName("Should process transfer transaction and mark successful")
    void testProcessTransaction() {
        Card card = buildCard();
        TransactionDTO transactionDTO = buildSuccessfulTransactionDTO();
        TransferTransaction transferTransaction = buildSuccessfulTransferTransaction();


        when(cardService.findByCardNumber(transactionDTO.getCardNumber())).thenReturn(card);
        when(cardService.getIdByCardNumber(transactionDTO.getDestinationCardNumber())).thenReturn(DESTINATION_CARD_ID);
        when(cardService.deposit(transactionDTO.getAmount(), DESTINATION_CARD_ID)).thenReturn(true);
        when(cardService.withdraw(transactionDTO.getAmount(), card.getId())).thenReturn(true);
        when(transferTransactionRepository.save(any())).thenReturn(transferTransaction);
        when(transferTransactionMapper.updateTransactionDTO(transferTransaction, transactionDTO)).thenReturn(transactionDTO);

        TransactionDTO processedTransaction = transferTransactionService.processTransaction(transactionDTO);

        ArgumentCaptor<TransferTransaction> transferTransactionCaptor =
                ArgumentCaptor.forClass(TransferTransaction.class);
        verify(transferTransactionRepository).save(transferTransactionCaptor.capture());
        TransferTransaction captor = transferTransactionCaptor.getValue();

        assertEquals(captor.getAmount(), processedTransaction.getAmount());
        assertTrue(captor.isSuccessful());
        verify(transferTransactionRepository).save(any());
        assertEquals(processedTransaction.getTransactionType(), TransactionType.TRANSFER);
    }

    @Test
    @DisplayName("Should process transfer transaction and mark failed")
    void testProcessTransactionException() {
        Card card = buildCard();
        TransactionDTO transactionDTO = buildFailedTransactionDTO();
        TransferTransaction transferTransaction = buildFailedTransferTransaction();


        when(cardService.findByCardNumber(transactionDTO.getCardNumber())).thenReturn(card);
        when(cardService.getIdByCardNumber(transactionDTO.getDestinationCardNumber())).thenReturn(DESTINATION_CARD_ID);
        when(transferTransactionRepository.save(any())).thenReturn(transferTransaction);
        when(transferTransactionMapper.updateTransactionDTO(any(), any())).thenReturn(transactionDTO);
        TransactionDTO processedTransaction = transferTransactionService.processTransaction(transactionDTO);

        ArgumentCaptor<TransferTransaction> transferTransactionCaptor =
                ArgumentCaptor.forClass(TransferTransaction.class);
        verify(transferTransactionRepository).save(transferTransactionCaptor.capture());
        TransferTransaction captor = transferTransactionCaptor.getValue();

        assertEquals(captor.getAmount(), processedTransaction.getAmount());
        assertFalse(captor.isSuccessful());
        verify(transferTransactionRepository).save(any());
        verify(cardService, never()).deposit(transactionDTO.getAmount(), DESTINATION_CARD_ID);
        verify(cardService, never()).withdraw(transactionDTO.getAmount(), card.getId());
        assertEquals(processedTransaction.getTransactionType(), TransactionType.TRANSFER);
    }

    private static TransferTransaction buildSuccessfulTransferTransaction() {
        return TransferTransaction.builder()
                .transactionUUID(UUID.fromString(TRANSACTION_UUID))
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .destinationCardId(DESTINATION_CARD_ID)
                .build();
    }

    private static TransferTransaction buildFailedTransferTransaction() {
        return TransferTransaction.builder()
                .transactionUUID(UUID.fromString(TRANSACTION_UUID))
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .destinationCardId(DESTINATION_CARD_ID)
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
                .destinationCardNumber(DESTINATION_CARD_NUMBER)
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .isSuspicious(false)
                .isSuccessful(true)
                .build();
    }

    private static TransactionDTO buildFailedTransactionDTO() {
        return TransactionDTO.builder()
                .cardNumber(CARD_NUMBER)
                .destinationCardNumber(DESTINATION_CARD_NUMBER)
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .isSuspicious(false)
                .isSuccessful(false)
                .build();
    }
}
