package ua.lysenko.banking.card.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCardResponseModel {
    private String cardNumber;
    private BigDecimal balance;
    private Date expirationDate;

    private int cvv;
    private String cardHolderName;

    private String cardHolderLastName;
    private String walletNumber;
}
