package ua.lysenko.banking.card.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class CardResponseModel {
    private Long id;
    private String cardNumber;
    private BigDecimal balance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date expirationDate;
    private int cvv;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cardHolderName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cardHolderLastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String walletNumber;
    private boolean active;

}
