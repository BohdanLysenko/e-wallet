package ua.lysenko.banking.transaction.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseModel {
    private String transactionUUID;
    private BigDecimal amount;
    private boolean isSuccessful;
    private Instant createdDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cardNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String destinationCardNumber;
    private String transactionType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long merchantId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errorMsgs;
}
