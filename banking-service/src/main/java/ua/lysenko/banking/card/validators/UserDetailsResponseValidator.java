package ua.lysenko.banking.card.validators;

import common.grpc.Users.UserMessage;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.validators.BaseValidator;

@Component
public class UserDetailsResponseValidator implements BaseValidator<UserMessage> {
    @Override
    public boolean isValid(UserMessage response) {
        return response.getEnabled();
    }

}
