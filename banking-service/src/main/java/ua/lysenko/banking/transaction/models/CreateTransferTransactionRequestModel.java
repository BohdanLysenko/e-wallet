package ua.lysenko.banking.transaction.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransferTransactionRequestModel extends CreateTransactionRequestModel {
    @NotNull(message = "Destination Card Number must be provided")
    private String destinationCardNumber;
}
