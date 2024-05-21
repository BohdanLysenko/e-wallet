package ua.lysenko.banking.utils.validators;

import org.springframework.stereotype.Component;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.validators.BaseValidator;

@Component
public class TransactionSenderValidator implements BaseValidator<TransactionValidationModel> {
    @Override
    public boolean isValid(TransactionValidationModel transaction) {
        return transaction.getTransactionType() == TransactionType.DEPOSIT ||
                (transaction.getPersistUserId().equals(transaction.getRequestUserId()) &&
                        (transaction.getTransactionType() == TransactionType.TRANSFER ||
                                transaction.getTransactionType() == TransactionType.WITHDRAWAL ||
                                transaction.getTransactionType() == TransactionType.PAYMENT));

    }
}
