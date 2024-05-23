package ua.lysenko.banking.transaction.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentTransactionRequestModel extends CreateTransactionRequestModel {
    @NotNull(message = "Merchant ID must be provided")
    private Long merchantId;
}
