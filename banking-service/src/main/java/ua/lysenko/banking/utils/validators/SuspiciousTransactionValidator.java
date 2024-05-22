package ua.lysenko.banking.utils.validators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.validators.BaseValidator;

import java.math.BigDecimal;

@Component
public class SuspiciousTransactionValidator implements BaseValidator<TransactionValidationModel> {

    private final BigDecimal suspiciousTransactionAmount;

    public SuspiciousTransactionValidator(@Value("${transaction.limit.suspicious}") BigDecimal suspiciousTransactionAmount) {
        this.suspiciousTransactionAmount = suspiciousTransactionAmount;
    }

    @Override
    public boolean isValid(TransactionValidationModel transaction) {
        return transaction.getAmount().compareTo(suspiciousTransactionAmount) < 0;
    }

}
