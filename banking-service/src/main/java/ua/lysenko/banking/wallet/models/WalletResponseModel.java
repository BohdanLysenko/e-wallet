package ua.lysenko.banking.wallet.models;

import lombok.Builder;
import lombok.Data;
import ua.lysenko.banking.card.models.CardResponseModel;

import java.util.List;

@Data
@Builder
public class WalletResponseModel {
    private Long id;
    private String walletNumber;

    String walletHolderName;
    String walletHolderLastName;
    List<CardResponseModel> cards;
    private boolean active;

}
