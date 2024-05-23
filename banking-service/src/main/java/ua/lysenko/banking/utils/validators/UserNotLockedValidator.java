package ua.lysenko.banking.utils.validators;

import common.grpc.users.UserMessage;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.validators.BaseValidator;

@Component
public class UserNotLockedValidator implements BaseValidator<UserMessage> {
    @Override
    public boolean isValid(UserMessage user) {
        return user.getTransactionBlocked();
    }
}
