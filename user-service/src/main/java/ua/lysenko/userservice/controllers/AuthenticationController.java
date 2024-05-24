package ua.lysenko.userservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lysenko.userservice.service.AuthenticationService;
import ua.lysenko.userservice.ui.models.SignInRequest;
import ua.lysenko.userservice.ui.models.SignInResponse;
import ua.lysenko.userservice.ui.models.SignUpRequest;
import ua.lysenko.userservice.ui.models.SignUpResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authenticationService.signUp(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authenticationService.signIn(request));
    }
}