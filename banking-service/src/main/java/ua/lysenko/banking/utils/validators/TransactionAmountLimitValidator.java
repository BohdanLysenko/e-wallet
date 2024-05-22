package ua.lysenko.banking.utils.validators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.validators.BaseValidator;

import java.math.BigDecimal;

@Component
public class TransactionAmountLimitValidator implements BaseValidator<TransactionValidationModel> {

    private final BigDecimal singleTransactionAmountLimit;

    public TransactionAmountLimitValidator(@Value("${transaction.limit.single}")
                                           BigDecimal singleTransactionAmountLimit) {
        this.singleTransactionAmountLimit = singleTransactionAmountLimit;
    }

    @Override
    public boolean isValid(TransactionValidationModel transaction) {
        return transaction.getAmount().compareTo(singleTransactionAmountLimit) < 0;
    }

}
