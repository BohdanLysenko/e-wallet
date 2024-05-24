package ua.lysenko.userservice.validators;

import org.springframework.stereotype.Component;
import ua.lysenko.userservice.repository.UsersRepository;
import ua.lysenko.userservice.ui.models.SignUpRequest;

@Component
public class SignUpEmailValidator implements BaseValidator<SignUpRequest> {

    private final UsersRepository usersRepository;

    public SignUpEmailValidator(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean isValid(SignUpRequest signUpRequest) {
        return usersRepository.findByEmail(signUpRequest.getEmail()).isEmpty();
    }
}
