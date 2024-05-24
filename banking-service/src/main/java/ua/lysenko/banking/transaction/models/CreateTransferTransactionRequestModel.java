package ua.lysenko.banking.transaction.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreateTransferTransactionRequestModel extends CreateTransactionRequestModel {
    @NotNull(message = "Destination Card Number must be provided")
    private String destinationCardNumber;
}
