package ua.lysenko.userservice.service;

import ua.lysenko.userservice.ui.models.SignInRequest;
import ua.lysenko.userservice.ui.models.SignInResponse;
import ua.lysenko.userservice.ui.models.SignUpRequest;
import ua.lysenko.userservice.ui.models.SignUpResponse;

public interface AuthenticationService {
    SignUpResponse signUp(SignUpRequest request);

    SignInResponse signIn(SignInRequest request);
}