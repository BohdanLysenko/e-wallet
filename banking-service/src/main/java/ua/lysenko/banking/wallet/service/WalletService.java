package ua.lysenko.banking.wallet.service;


import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.wallet.dto.WalletDTO;

public interface WalletService {

    WalletDTO createWallet(Long userID);

    Wallet getWalletByUserId(Long userId);
}
