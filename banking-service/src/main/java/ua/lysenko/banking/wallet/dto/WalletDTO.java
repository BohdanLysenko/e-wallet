package ua.lysenko.banking.wallet.dto;

import lombok.Data;

@Data
public class WalletDTO {
    private Long id;
    private String walletNumber;
    private Long userId;
}
