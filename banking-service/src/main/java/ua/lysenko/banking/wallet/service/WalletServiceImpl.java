package ua.lysenko.banking.wallet.service;

import common.grpc.users.UserMessage;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.repository.CardRepository;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.exception.WalletNotFoundException;
import ua.lysenko.banking.service.CommonBankingServiceGrpc;
import ua.lysenko.banking.utils.mappers.CardMapper;
import ua.lysenko.banking.utils.mappers.WalletMapper;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.wallet.dto.WalletDTO;
import ua.lysenko.banking.wallet.repository.WalletRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    private final WalletMapper walletMapper;
    private final CommonBankingServiceGrpc commonBankingServiceService;
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;

    public WalletServiceImpl(WalletRepository walletRepository, WalletMapper walletMapper, CommonBankingServiceGrpc commonBankingServiceService, CardMapper cardMapper,
                             CardRepository cardRepository) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
        this.commonBankingServiceService = commonBankingServiceService;
        this.cardMapper = cardMapper;
        this.cardRepository = cardRepository;
    }

    @Override
    public WalletDTO createWallet(Long userID) {
        Wallet createdWallet = Wallet.builder()
                .userId(userID)
                .walletNumber(UUID.randomUUID())
                .active(true)
                .build();
        createdWallet = walletRepository.save(createdWallet);
        return walletMapper.toWalletDTO(createdWallet);
    }

    @Override
    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    @Override
    public WalletDTO getWallet(String token) {
        UserMessage userMessage = commonBankingServiceService.getCurrentUser(token);
        Wallet wallet = walletRepository.findByUserIdAndActiveIsTrue(userMessage.getId())
                .orElseThrow(() -> new WalletNotFoundException(ExceptionKeys.WALLET_NOT_FOUND.getMessage()));
        WalletDTO walletDTO = walletMapper.toWalletDTO(wallet);
        List<Card> cards = cardRepository.findAllByWalletAndActiveIsTrue(walletDTO.getId());
        walletDTO.setCards(cardMapper.cardsToCardDTOs(cards));
        walletDTO.setWalletHolderName(userMessage.getFirstName());
        walletDTO.setWalletHolderLastName(userMessage.getLastName());
        return walletDTO;
    }

    @Override
    public void deleteWallet(String token) {
        UserMessage userMessage = commonBankingServiceService.getCurrentUser(token);
        Wallet wallet = findActiveWalletByUserId(userMessage.getId());
        wallet.setActive(false);
        cardRepository.deactivateAllCards(wallet.getId());
    }

    @Override
    public Wallet findActiveWalletByUserId(Long userId) {
        return walletRepository.findByUserIdAndActiveIsTrue(userId)
                .orElseThrow(() -> new WalletNotFoundException(ExceptionKeys.WALLET_NOT_FOUND.getMessage()));
    }
}
