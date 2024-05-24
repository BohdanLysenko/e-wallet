package ua.lysenko.banking.card.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class CardDTO {
    private Long id;
    private String cardNumber;
    private BigDecimal balance;
    private Date expirationDate;
    private String cardHolderName;
    private String cardHolderLastName;
    private int cvv;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String walletNumber;
    private Long walletId;

    private boolean active;

}
