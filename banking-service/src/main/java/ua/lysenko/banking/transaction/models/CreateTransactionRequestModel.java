package ua.lysenko.banking.transaction.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreateTransactionRequestModel {
    @NotNull(message = "amount should not be null")
    @Positive(message = "amount should be a positive number")
    protected BigDecimal amount;

    @NotNull(message = "cardId should be provided")
    protected String cardNumber;
}
