package ua.lysenko.banking.transaction.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreatePaymentTransactionRequestModel extends CreateTransactionRequestModel {
    @NotNull(message = "Merchant ID must be provided")
    private Long merchantId;
}
