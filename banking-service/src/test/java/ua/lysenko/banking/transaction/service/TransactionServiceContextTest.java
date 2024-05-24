package ua.lysenko.banking.transaction.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import common.grpc.users.UserMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.service.CommonBankingServiceGrpc;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.service.TransactionService;
import ua.lysenko.banking.transaction.service.TransactionServiceContext;
import ua.lysenko.banking.transaction.service.implementation.DepositTransactionService;
import ua.lysenko.banking.utils.mappers.TransactionContextMapper;
import ua.lysenko.banking.utils.validators.impl.TransactionValidatorChain;

import java.math.BigDecimal;
import java.util.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceContextTest {

    public static final String VALID_TOKEN = "12312asdfas2";
    @Mock
    private Map<TransactionType, TransactionService> processTransactionByType;

    @Mock
    private CardService cardService;

    @Mock
    private TransactionValidatorChain validatorChain;

    @Mock
    private TransactionContextMapper transactionMapper;

    @Mock
    private CommonBankingServiceGrpc commonBankingServiceService;

    @Mock
    DepositTransactionService depositTransactionService;

    @InjectMocks
    private TransactionServiceContext transactionServiceContext;


    @Test
    @DisplayName("Should process transaction successfully")
    void testProcessTransaction() {
        TransactionDTO transaction = TransactionDTO.builder()
                .cardNumber("1231231231")
                .destinationCardNumber("5678941462")
                .amount(BigDecimal.valueOf(10000))
                .build();

        TransactionType transactionType = TransactionType.DEPOSIT;

        UserMessage userMessage = UserMessage.newBuilder()
                .setId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .setTransactionBlocked(false)
                .setSuspiciousActivityDetected(false)
                .build();

        when(processTransactionByType.get(transactionType)).thenReturn(depositTransactionService);
        when(commonBankingServiceService.getCurrentUser(anyString())).thenReturn(userMessage);
        when(cardService.findByCardNumber(transaction.getCardNumber()))
                .thenReturn(Card.builder().wallet(Wallet.builder().userId(1L).build()).build());
        doNothing().when(validatorChain).validate(any(), any());
        when(transactionMapper.updateTransactionDTO(any(), any()))
                .thenReturn(transaction);
        when(depositTransactionService.processTransaction(transaction)).thenReturn(transaction);

        TransactionDTO actual = transactionServiceContext.processTransaction(VALID_TOKEN, transaction, transactionType);

        verify(commonBankingServiceService).getCurrentUser(VALID_TOKEN);
        verify(cardService).findByCardNumber(transaction.getCardNumber());
        verify(validatorChain).validate(any(), any());
        verify(transactionMapper).updateTransactionDTO(any(), any());

        assertEquals(transaction, actual);
    }
}