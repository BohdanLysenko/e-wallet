package ua.lysenko.banking.wallet.service;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.utils.MapperUtils;
import ua.lysenko.banking.wallet.dto.WalletDTO;
import ua.lysenko.banking.wallet.repository.WalletRepository;

import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public WalletDTO createWallet(Long userID) {
        Wallet createdWallet = Wallet.builder()
                .userId(userID)
                .walletNumber(UUID.randomUUID())
                .build();
        createdWallet = walletRepository.save(createdWallet);
        //Todo formatting text resources
        WalletDTO createdWalletDTO = MapperUtils.map(createdWallet, WalletDTO.class);
        logger.info(String.format("Created wallet[id: %s, number: %s, " +
                        "userId: %s]", createdWalletDTO.getId(),
                createdWalletDTO.getWalletNumber(), createdWalletDTO.getUserId()));
        return createdWalletDTO;
    }

    // ToDo expection message handler
    @Override
    public Wallet getWalletByUserId(Long userId) {
        return walletRepository.findByUserId(userId).orElseThrow(() -> new EntityNotFoundException("no such user"));
    }
}
