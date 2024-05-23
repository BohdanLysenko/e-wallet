package ua.lysenko.banking.transaction.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionValidationResult {

    private boolean isValid;
    private boolean isSuspicious;
}
