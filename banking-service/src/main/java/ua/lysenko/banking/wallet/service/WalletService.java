package ua.lysenko.banking.wallet.service;


import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.wallet.dto.WalletDTO;

import java.util.List;

public interface WalletService {

    WalletDTO createWallet(Long userID);


    List<Wallet> getAllWallets();

    WalletDTO getWalletByToken(String token);

    WalletDTO getWalletByUserId(Long userId);

    void deleteWallet(String token);

    Wallet findActiveWalletByUserId(Long userId);
}
