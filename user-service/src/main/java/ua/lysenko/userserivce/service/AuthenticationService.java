package ua.lysenko.userserivce.service;

import ua.lysenko.userserivce.ui.models.SignInResponse;
import ua.lysenko.userserivce.ui.models.SignUpResponse;
import ua.lysenko.userserivce.ui.models.SignUpRequest;
import ua.lysenko.userserivce.ui.models.SignInRequest;

public interface AuthenticationService {
    SignUpResponse signup(SignUpRequest request);

    SignInResponse signin(SignInRequest request);
}