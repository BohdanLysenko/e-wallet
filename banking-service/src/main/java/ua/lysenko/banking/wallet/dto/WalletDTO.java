package ua.lysenko.banking.wallet.dto;

import lombok.Builder;
import lombok.Data;
import ua.lysenko.banking.card.DTO.CardDTO;

import java.util.List;

@Data
@Builder
public class WalletDTO {
    private Long id;
    private String walletNumber;
    private Long userId;

    private List<CardDTO> cards;
    String walletHolderName;
    String walletHolderLastName;

    private boolean active;

}
