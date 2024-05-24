package ua.lysenko.banking.transaction.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TransactionValidationResult {

    private boolean isValid;
    private boolean isSuspicious;
    private List<String> errorMsg;
    private boolean userShouldBeTransactionBlocked;
    private boolean userShouldBeMarkedSuspicious;
    private Long requestUserId;
}
