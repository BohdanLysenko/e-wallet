package ua.lysenko.userserivce.validators;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lysenko.userserivce.repository.UsersRepository;
import ua.lysenko.userserivce.ui.models.SignUpRequest;

@Component
@AllArgsConstructor
public class SignUpEmailValidator implements BaseValidator<SignUpRequest> {

    UsersRepository usersRepository;

    @Override
    public boolean isValid(SignUpRequest signUpRequest) {
        return usersRepository.findByEmail(signUpRequest.getEmail()).isEmpty();
    }
}
