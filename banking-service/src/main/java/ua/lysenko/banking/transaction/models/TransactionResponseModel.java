package ua.lysenko.banking.transaction.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseModel {
    private String transactionUUID;
    private BigDecimal balance;
    private BigDecimal amount;
    private boolean isSuccessful;
    private Date createdDate;
    private String cardNumber;
    @JsonIgnoreProperties
    private String destinationCardNumber;
    private String transactionType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDestinationCardNumber() {
        return destinationCardNumber;
    }


}
