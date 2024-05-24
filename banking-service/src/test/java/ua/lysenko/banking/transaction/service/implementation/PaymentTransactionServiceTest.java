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
import ua.lysenko.banking.entity.PaymentTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.repository.PaymentTransactionRepository;
import ua.lysenko.banking.transaction.service.implementation.PaymentTransactionService;
import ua.lysenko.banking.utils.mappers.PaymentTransactionMapper;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentTransactionServiceTest {

    public static final String TRANSACTION_UUID = "b9ef8a70-1d81-4908-9357-0bb3c3a0a7a6";
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(1500);
    public static final long CARD_ID = 1L;
    public static final String CARD_NUMBER = "123123123";
    public static final long MERCHANT_ID = 5L;
    @Mock
    private CardService cardService;
    @Mock
    private PaymentTransactionRepository paymentTransactionRepository;

    @Mock
    private PaymentTransactionMapper paymentTransactionMapper;


    @InjectMocks
    PaymentTransactionService paymentTransactionService;

    @Test
    @DisplayName("Should process payment transaction and mark successful")
    void testProcessTransaction() {
        Card card = buildCard();
        TransactionDTO transactionDTO = buildSuccessfulTransactionDTO();
        PaymentTransaction paymentTransaction = buildSuccessfulPaymentTransaction();

        when(cardService.findByCardNumber(transactionDTO.getCardNumber())).thenReturn(card);
        when(cardService.withdraw(transactionDTO.getAmount(), card.getId())).thenReturn(true);
        when(paymentTransactionRepository.save(any())).thenReturn(paymentTransaction);
        when(paymentTransactionMapper.updateTransactionDTO(any(), any())).thenReturn(transactionDTO);

        TransactionDTO processedTransaction = paymentTransactionService.processTransaction(transactionDTO);

        ArgumentCaptor<PaymentTransaction> paymentTransactionCaptor =
                ArgumentCaptor.forClass(PaymentTransaction.class);
        verify(paymentTransactionRepository).save(paymentTransactionCaptor.capture());
        PaymentTransaction captor = paymentTransactionCaptor.getValue();

        assertEquals(captor.getAmount(), processedTransaction.getAmount());
        assertTrue(captor.isSuccessful());
        verify(paymentTransactionRepository).save(any());
        assertEquals(processedTransaction.getTransactionType(), TransactionType.PAYMENT);
    }

    @Test
    @DisplayName("Should process payment transaction and mark failed")
    void testProcessTransactionFail() {
        Card card = buildCard();
        TransactionDTO transactionDTO = buildFailedTransactionDTO();
        PaymentTransaction paymentTransaction = buildFailedPaymentTransaction();


        when(cardService.findByCardNumber(transactionDTO.getCardNumber())).thenReturn(card);
        when(paymentTransactionRepository.save(any())).thenReturn(paymentTransaction);
        when(paymentTransactionMapper.updateTransactionDTO(any(), any())).thenReturn(transactionDTO);

        TransactionDTO processedTransaction = paymentTransactionService.processTransaction(transactionDTO);

        ArgumentCaptor<PaymentTransaction> paymentTransactionCaptor =
                ArgumentCaptor.forClass(PaymentTransaction.class);
        verify(paymentTransactionRepository).save(paymentTransactionCaptor.capture());
        PaymentTransaction captor = paymentTransactionCaptor.getValue();

        assertEquals(captor.getAmount(), processedTransaction.getAmount());
        assertFalse(captor.isSuccessful());
        verify(paymentTransactionRepository).save(any());
        verify(cardService, never()).withdraw(transactionDTO.getAmount(), card.getId());
        assertEquals(processedTransaction.getTransactionType(), TransactionType.PAYMENT);
    }

    private static PaymentTransaction buildSuccessfulPaymentTransaction() {
        return PaymentTransaction.builder()
                .transactionUUID(UUID.fromString(TRANSACTION_UUID))
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .merchantId(MERCHANT_ID)
                .build();
    }

    private static PaymentTransaction buildFailedPaymentTransaction() {
        return PaymentTransaction.builder()
                .transactionUUID(UUID.fromString(TRANSACTION_UUID))
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .merchantId(MERCHANT_ID)
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
                .merchantId(MERCHANT_ID)
                .build();
    }

    private static TransactionDTO buildFailedTransactionDTO() {
        return TransactionDTO.builder()
                .cardNumber(CARD_NUMBER)
                .amount(AMOUNT)
                .cardId(CARD_ID)
                .isSuspicious(false)
                .isSuccessful(false)
                .merchantId(MERCHANT_ID)
                .build();
    }
}
