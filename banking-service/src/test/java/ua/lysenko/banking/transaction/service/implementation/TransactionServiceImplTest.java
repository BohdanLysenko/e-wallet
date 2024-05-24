package ua.lysenko.banking.transaction.service.implementation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Transaction;
import ua.lysenko.banking.exception.UnauthorizedAccessException;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.repository.TransactionRepository;
import ua.lysenko.banking.utils.mappers.TransactionMapper;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.wallet.dto.WalletDTO;
import ua.lysenko.banking.wallet.service.WalletService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

    public static final String TRANSACTION_UUID = "b9ef8a70-1d81-4908-9357-0bb3c3a0a7a6";
    public static final String VALID_TOKEN = "easdfsa1231sa";
    public static final Long WALLET_ID = 20L;
    public static final Long USER_ID = 5L;
    public static final long CARD_ID = 1L;
    public static final String CARD_NUMBER = "123123123";

    @Mock
    private WalletService walletService;
    @Mock
    private CardService cardService;

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private TransactionMapper transactionMapper;

    @InjectMocks
    TransactionServiceImpl transactionService;

    @Test
    @DisplayName("Should get all transactions by card number")
    void getAllTransactions() {
        WalletDTO walletDTO = buildWalletDTO(WALLET_ID);
        CardDTO cardDTO = buildCardDTO();
        TransactionDTO transactionDTO = buildTransactionDTO();
        List<Transaction> transactionsList = new ArrayList<>(List.of(buildTransaction(), buildTransaction(),
                buildTransaction()));
        Pageable pageable = PageRequest.of(0, 10);
        Page<Transaction> transactions = new PageImpl<>(transactionsList, pageable, transactionsList.size());


        when(walletService.getWallet(VALID_TOKEN)).thenReturn(walletDTO);
        when(cardService.getByCardNumber(CARD_NUMBER)).thenReturn(cardDTO);
        when(transactionRepository.findAllByCardIdOrderByCreatedDateDesc(any(),
                any())).thenReturn(transactions);
        when(transactionMapper.toTransactionDTO(any(Transaction.class))).thenReturn(transactionDTO);
        when(transactionMapper.updateTransactionDTO(any(Transaction.class), any(TransactionDTO.class)))
                .thenReturn(transactionDTO);

        List<TransactionDTO> result = transactionService.getAllTransactionsByCardId(VALID_TOKEN, CARD_NUMBER, pageable);

        verify(transactionRepository).findAllByCardIdOrderByCreatedDateDesc(any(), any());
        assertEquals(transactionsList.size(), result.size());
        assertEquals(result.get(0).getTransactionType(), TransactionType.TRANSACTION);

    }

    @Test
    @DisplayName("Should throw UnauthorizedAccessException when the request is sent not by card owner")
    void getAllTransactionsException() {
        WalletDTO walletDTO = buildWalletDTO(123L);
        CardDTO cardDTO = buildCardDTO();

        when(walletService.getWallet(VALID_TOKEN)).thenReturn(walletDTO);
        when(cardService.getByCardNumber(CARD_NUMBER)).thenReturn(cardDTO);

        UnauthorizedAccessException exception =
                assertThrows(UnauthorizedAccessException.class, () ->
                        transactionService.getAllTransactionsByCardId(VALID_TOKEN, CARD_NUMBER,
                                PageRequest.of(0, 20)));

        assertEquals(ExceptionKeys.UNAUTHORIZED_ACCESS.getMessage(), exception.getMessage());

    }

    private static WalletDTO buildWalletDTO(Long id) {
        return WalletDTO.builder()
                .id(id)
                .userId(TransactionServiceImplTest.USER_ID)
                .walletNumber(UUID.randomUUID().toString())
                .build();
    }

    private static CardDTO buildCardDTO() {
        return CardDTO.builder()
                .id(CARD_ID)
                .cardNumber(CARD_NUMBER)
                .balance(BigDecimal.valueOf(10000))
                .walletId(WALLET_ID)
                .build();
    }

    private static Transaction buildTransaction() {
        return Transaction.builder()
                .transactionUUID(UUID.fromString(TRANSACTION_UUID))
                .amount(BigDecimal.TEN)
                .isSuccessful(true)
                .isSuspicious(false)
                .cardId(CARD_ID)
                .build();
    }

    private static TransactionDTO buildTransactionDTO() {
        return TransactionDTO.builder()
                .transactionUUID(TRANSACTION_UUID)
                .amount(BigDecimal.TEN)
                .isSuccessful(true)
                .isSuspicious(false)
                .cardId(CARD_ID)
                .build();
    }

}
