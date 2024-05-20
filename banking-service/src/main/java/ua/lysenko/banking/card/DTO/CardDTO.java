package ua.lysenko.banking.card.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CardDTO {
    private String cardNumber;
    private BigDecimal balance;
    private Date expirationDate;
    private int cvv;

    private String walletNumber;

}
