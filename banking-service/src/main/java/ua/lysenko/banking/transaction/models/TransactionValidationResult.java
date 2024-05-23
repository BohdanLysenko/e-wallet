package ua.lysenko.banking.transaction.models;

import lombok.Builder;
import lombok.Data;
import ua.lysenko.banking.transaction.enums.TransactionType;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionValidationResult {

    private boolean isValid;
    private boolean isSuspicious;
}
