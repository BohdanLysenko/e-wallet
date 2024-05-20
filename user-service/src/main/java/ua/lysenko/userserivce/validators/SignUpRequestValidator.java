package ua.lysenko.userserivce.validators;

import ua.lysenko.userserivce.ui.models.SignUpRequest;

public class SignUpRequestValidator implements BaseValidator<SignUpRequest> {

    @Override
    public boolean isValid(SignUpRequest signUpRequest) {
        return signUpRequest.getPassword()
                .matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$");
    }
}
