package ua.lysenko.banking.card.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date expirationDate;

    private int cvv;
    private String cardHolderName;

    private String cardHolderLastName;
    private String walletNumber;
}
