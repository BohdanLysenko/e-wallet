package ua.lysenko.banking.transaction.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseModel {
    private String transactionUUID;
    private BigDecimal amount;
    private boolean isSuccessful;
    private Instant createdDate;
    private String cardNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String destinationCardNumber;
    private String transactionType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long merchantId;




}
