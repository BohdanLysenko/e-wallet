package ua.lysenko.userservice.validators;

import org.springframework.stereotype.Component;
import ua.lysenko.userservice.ui.models.SignUpRequest;

@Component
public class SignUpPasswordValidator implements BaseValidator<SignUpRequest> {

    @Override
    public boolean isValid(SignUpRequest signUpRequest) {
        return signUpRequest.getPassword()
                .matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$");
    }
}
