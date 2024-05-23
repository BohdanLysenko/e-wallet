package ua.lysenko.banking.utils.validators.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.exception.AccountIsLockedException;
import ua.lysenko.banking.transaction.models.TransactionValidationModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.AbstractTransactionValidator;

@Slf4j
@Component
public class UserTransactionBlockedValidator extends AbstractTransactionValidator {
    @Override
    public void validate(TransactionValidationModel user, TransactionValidationResult result) {
        if (user.isUserTransactionBlocked()) {
            log.warn(ExceptionKeys.ACCOUNT_IS_LOCKED.getMessage());
            throw new AccountIsLockedException(ExceptionKeys.ACCOUNT_IS_LOCKED.getMessage());
        }
        next(user, result);
    }
}
