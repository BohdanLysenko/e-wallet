package ua.lysenko.card.service;

import common.grpc.users.UserMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.repository.CardRepository;
import ua.lysenko.banking.card.service.CardServiceImpl;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.exception.CardNotFoundException;
import ua.lysenko.banking.exception.UnauthorizedAccessException;
import ua.lysenko.banking.service.CommonBankingServiceGrpc;
import ua.lysenko.banking.utils.mappers.CardMapper;
import ua.lysenko.banking.wallet.dto.WalletDTO;
import ua.lysenko.banking.wallet.service.WalletService;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CardServiceImplTest {
    public static final Long ID = 1L;
    public static final Long USER_ID = 1L;

    public static final String VALID_TOKEN = "valid_token";
    public static final String CARD_NUMBER = "15637456471";

    @Mock
    private CardRepository cardRepository;
    @Mock
    private WalletService walletService;
    @Mock
    private CardMapper cardMapper;
    @Mock
    private CommonBankingServiceGrpc commonBankingServiceService;

    @InjectMocks
    CardServiceImpl cardService;

    @Test
    @DisplayName("Should create a new card for a wallet tied to user")
    void testCreateCard() {
        UserMessage userMessage = buildUserMessage();
        Wallet wallet = buildWallet();
        Card card = getCard(wallet);
        CardDTO expectedCardDTO = getCardDTO(wallet);

        when(commonBankingServiceService.getCurrentUser(VALID_TOKEN)).thenReturn(userMessage);
        when(walletService.findActiveWalletByUserId(userMessage.getId())).thenReturn(wallet);
        when(cardRepository.save(any())).thenReturn(card);
        when(cardMapper.toCardDto(any())).thenReturn(expectedCardDTO);

        CardDTO actualCardDTO = cardService.createCard(VALID_TOKEN);
        ArgumentCaptor<Card> cardCaptor = ArgumentCaptor.forClass(Card.class);
        verify(cardRepository).save(cardCaptor.capture());
        Card capturedCard = cardCaptor.getValue();

        assertEquals(expectedCardDTO.getCardNumber(), actualCardDTO.getCardNumber());
        assertEquals(expectedCardDTO.getId(), actualCardDTO.getId());

        assertEquals(BigDecimal.ZERO, capturedCard.getBalance());
        assertEquals(wallet, capturedCard.getWallet());
        assertTrue(capturedCard.isActive());
    }

    @Test
    @DisplayName("Should find card by card number")
    void testFindCardByCardNumber() {
        Card expectedCard = getCard(buildWallet());

        when(cardRepository.findIdByCardNumberAndActiveIsTrue(expectedCard.getCardNumber()))
                .thenReturn(Optional.ofNullable(expectedCard.getId()));

        Long actualCardId = cardService.getIdByCardNumber(expectedCard.getCardNumber());

        assertEquals(actualCardId, expectedCard.getId());
    }

    @Test
    @DisplayName("Should throw CardNotFoundException when card number is not found")
    void testFindCardByCardNumberException() {

        Card card = getCard(buildWallet());
        when(cardRepository.findIdByCardNumberAndActiveIsTrue(card.getCardNumber()))
                .thenReturn(Optional.empty());

        assertThrows(CardNotFoundException.class, () -> {
            cardService.getIdByCardNumber(card.getCardNumber());
        });
    }

    @Test
    @DisplayName("Should find card by card id")
    void testGetCardById() {
        Wallet wallet = buildWallet();
        WalletDTO walletDTO = buildWalletDTO();
        Card card = getCard(wallet);
        CardDTO expectedCardDTO = getCardDTO(wallet);

        when(walletService.getWalletByToken(VALID_TOKEN)).thenReturn(walletDTO);
        when(cardRepository.findByIdAndActiveIsTrue(card.getId())).thenReturn(Optional.of(card));
        when(cardMapper.toCardDto(card)).thenReturn(expectedCardDTO);


        CardDTO actualCardDTO = cardService.getById(card.getId(), VALID_TOKEN);

        assertEquals(actualCardDTO.getId(), expectedCardDTO.getId());
        assertEquals(actualCardDTO.getCardNumber(), expectedCardDTO.getCardNumber());
        verify(cardRepository).findByIdAndActiveIsTrue(actualCardDTO.getId());
    }

    @Test
    @DisplayName("Should throw UnauthorizedAccessException when card id is not tied to request user")
    void testGetCardByIdUnauthorizedException() {
        Wallet wallet = buildWallet();
        WalletDTO walletDTO = buildWalletDTO();
        Card card = getCard(wallet);
        Card requesterCard = Card.builder()
                .id(2L)
                .wallet(new Wallet())
                .cardNumber("test")
                .active(true)
                .build();

        when(walletService.getWalletByToken(VALID_TOKEN)).thenReturn(walletDTO);
        when(cardRepository.findByIdAndActiveIsTrue(card.getId())).thenReturn(Optional.ofNullable(requesterCard));

        assertThrows(UnauthorizedAccessException.class, () -> cardService.getById(card.getId(), VALID_TOKEN));

        verify(cardRepository).findByIdAndActiveIsTrue(card.getId());
    }

    @Test
    @DisplayName("Should deposit transaction amount to card balance")
    void testDeposit() {
        BigDecimal amount = new BigDecimal(10);
        Card card = getCard(buildWallet());

        when(cardRepository.findByIdAndActiveIsTrue(card.getId())).thenReturn(Optional.of(card));

        boolean actual = cardService.deposit(amount, card.getId());

        assertTrue(actual);
        assertEquals(amount, card.getBalance());
    }

    @Test
    @DisplayName("Should withdraw transaction amount from card balance")
    void testWithdraw() {
        BigDecimal amount = new BigDecimal(10);
        Card card = getCardWithBalance(buildWallet());

        when(cardRepository.findByIdAndActiveIsTrue(card.getId())).thenReturn(Optional.of(card));

        BigDecimal expectedAmount = card.getBalance().subtract(amount);

        boolean actual = cardService.withdraw(amount, card.getId());

        ArgumentCaptor<Card> cardCaptor = ArgumentCaptor.forClass(Card.class);
        verify(cardRepository).save(cardCaptor.capture());
        Card capturedCard = cardCaptor.getValue();

        assertTrue(actual);
        assertEquals(expectedAmount, capturedCard.getBalance());
    }

    @Test
    @DisplayName("Should return true when balance is exceeded")
    void testIsBalanceExceeded() {
        BigDecimal amount = new BigDecimal(2000);
        Card card = getCardWithBalance(buildWallet());

        when(cardRepository.findByIdAndActiveIsTrue(card.getId())).thenReturn(Optional.of(card));

        boolean actual = cardService.isBalanceExceeded(amount, card.getId());

        assertTrue(actual);
    }

    @Test
    @DisplayName("Should return false when balance is not exceeded")
    void testIsBalanceExceededFalse() {
        BigDecimal amount = new BigDecimal(1400);
        Card card = getCardWithBalance(buildWallet());

        when(cardRepository.findByIdAndActiveIsTrue(card.getId())).thenReturn(Optional.of(card));

        boolean actual = cardService.isBalanceExceeded(amount, card.getId());

        assertFalse(actual);
    }

    private static Card getCard(Wallet wallet) {
        return Card.builder()
                .id(ID)
                .wallet(wallet)
                .cardNumber(CARD_NUMBER)
                .balance(BigDecimal.ZERO)
                .active(true)
                .build();
    }

    private static Card getCardWithBalance(Wallet wallet) {
        return Card.builder()
                .id(ID)
                .wallet(wallet)
                .cardNumber(CARD_NUMBER)
                .balance(BigDecimal.valueOf(1500))
                .active(true)
                .build();
    }

    private static CardDTO getCardDTO(Wallet wallet) {
        return CardDTO.builder()
                .id(ID)
                .walletId(wallet.getId())
                .cardNumber(CARD_NUMBER)
                .balance(BigDecimal.ZERO)
                .active(true)
                .build();
    }

    private static Wallet buildWallet() {
        return Wallet.builder()
                .id(ID)
                .walletNumber(UUID.randomUUID())
                .userId(USER_ID)
                .active(true)
                .build();
    }

    private static WalletDTO buildWalletDTO() {
        return WalletDTO.builder()
                .id(ID)
                .walletNumber(String.valueOf(UUID.randomUUID()))
                .userId(USER_ID)
                .active(true)
                .build();
    }

    private static UserMessage buildUserMessage() {
        return UserMessage.newBuilder()
                .setId(ID)
                .setFirstName("John")
                .setLastName("Doe")
                .build();
    }
}
