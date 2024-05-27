package ua.lysenko.wallet.service;

import common.grpc.users.UserMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.lysenko.banking.card.repository.CardRepository;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.exception.WalletNotFoundException;
import ua.lysenko.banking.service.CommonBankingServiceGrpc;
import ua.lysenko.banking.utils.mappers.CardMapper;
import ua.lysenko.banking.utils.mappers.WalletMapper;
import ua.lysenko.banking.wallet.dto.WalletDTO;
import ua.lysenko.banking.wallet.repository.WalletRepository;
import ua.lysenko.banking.wallet.service.WalletServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WalletServiceImplTest {
    public static final Long ID = 1L;
    public static final Long USER_ID = ID;

    public static final String TOKEN = "valid_token";
    @Mock
    private WalletRepository walletRepository;

    @Mock
    private WalletMapper walletMapper;
    @Mock
    private CommonBankingServiceGrpc commonBankingServiceService;
    @Mock
    private CardMapper cardMapper;
    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    WalletServiceImpl walletService;

    @Test
    @DisplayName("Should create a new wallet")
    void testCreateNewWallet() {
        WalletDTO expectedWalletDTO = buildWalletDTO(ID, USER_ID);
        Wallet createdWallet = buildWallet();

        when(walletRepository.save(any(Wallet.class))).thenReturn(createdWallet);
        when(walletMapper.toWalletDTO(createdWallet)).thenReturn(expectedWalletDTO);

        WalletDTO actualWalletDTO = walletService.createWallet(USER_ID);

        assertEquals(expectedWalletDTO.getId(), actualWalletDTO.getId());
        assertEquals(expectedWalletDTO.getUserId(), actualWalletDTO.getUserId());
        assertEquals(expectedWalletDTO.getWalletNumber(), actualWalletDTO.getWalletNumber());
        verify(walletRepository).save(any(Wallet.class));
    }


    @Test
    @DisplayName("Should return wallet with all attached cards")
    void testGetWallet() {
        UserMessage userMessage = UserMessage.newBuilder()
                .setId(ID)
                .setFirstName("John")
                .setLastName("Doe")
                .build();
        WalletDTO expectedWalletDTO = buildWalletDTO(ID, USER_ID);

        Wallet wallet = buildWallet();
        List<Card> cards = Collections.emptyList();

        when(commonBankingServiceService.getCurrentUser(TOKEN)).thenReturn(userMessage);
        when(walletRepository.findByUserIdAndActiveIsTrue(USER_ID)).thenReturn(Optional.ofNullable(wallet));
        when(cardRepository.findAllByWalletAndActiveIsTrue(ID)).thenReturn(cards);
        when(walletMapper.toWalletDTO(wallet)).thenReturn(expectedWalletDTO);
        when(cardMapper.cardsToCardDTOs(cards)).thenReturn(Collections.emptyList());

        WalletDTO actualWalletDTO = walletService.getWalletByToken(TOKEN);

        assertEquals(expectedWalletDTO, actualWalletDTO);
        verify(commonBankingServiceService).getCurrentUser(TOKEN);
        verify(cardRepository).findAllByWalletAndActiveIsTrue(ID);
        verify(walletMapper).toWalletDTO(wallet);
        verify(cardMapper).cardsToCardDTOs(cards);
    }
    @Test
    @DisplayName("Should throw exception when no wallets are found")
    void testGetWalletException() {
        UserMessage userMessage = UserMessage.newBuilder()
                .setId(ID)
                .setFirstName("John")
                .setLastName("Doe")
                .build();

        when(commonBankingServiceService.getCurrentUser(TOKEN)).thenReturn(userMessage);
        when(walletRepository.findByUserIdAndActiveIsTrue(USER_ID)).thenReturn(Optional.empty());

        assertThrows(WalletNotFoundException.class, () -> walletService.getWalletByToken(TOKEN));
    }


    @Test
    @DisplayName("Should return wallet by userId")
    void testFindActiveWalletByUserId() {
        Wallet expectedWallet = buildWallet();
        when(walletRepository.findByUserIdAndActiveIsTrue(USER_ID)).thenReturn(Optional.of(expectedWallet));

        Wallet result = walletService.findActiveWalletByUserId(USER_ID);

        assertEquals(expectedWallet, result);
    }

    private static Wallet buildWallet() {
        return Wallet.builder()
                .id(ID)
                .userId(USER_ID)
                .active(true)
                .build();
    }

    private static WalletDTO buildWalletDTO(Long id, Long USER_ID) {
        WalletDTO expectedWalletDTO = WalletDTO.builder()
                .id(id)
                .userId(USER_ID)
                .walletNumber(UUID.randomUUID().toString())
                .build();
        return expectedWalletDTO;
    }
}
