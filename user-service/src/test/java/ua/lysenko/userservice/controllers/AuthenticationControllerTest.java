package ua.lysenko.userservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.lysenko.userservice.service.AuthenticationService;
import ua.lysenko.userservice.service.JwtService;
import ua.lysenko.userservice.service.UserService;
import ua.lysenko.userservice.textresources.TextResources;
import ua.lysenko.userservice.ui.models.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticationController.class)
@ExtendWith({SpringExtension.class})
class AuthenticationControllerTest {

    public static final String VALID_TOKEN = "easdfsa1231sa";
    public static final String USER_EMAIL = "testuser@example.com";
    public static final String USER_LAST_NAME = "lastname";
    public static final String FIRST_NAME = "testuser";
    public static final String WALLET_NUMBER = "12312312";
    public static final String USER_PASSWORD = "basdfd12!";
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    UserService userService;

    @MockBean
    JwtService jwtService;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }


    @Test
    @DisplayName("Create a new user with wallet")
    void signUp() throws Exception {
        SignUpResponse signUpResponse = buildSignUpResponse();
        SignUpRequest signUpRequest = buildSignUpRequest();

        when(authenticationService.signUp(signUpRequest)).thenReturn(signUpResponse);

        mockMvc.perform(post("/auth/signup")
                        .content(asJsonString(signUpRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value(FIRST_NAME))
                .andExpect(jsonPath("$.lastName").value(USER_LAST_NAME))
                .andExpect(jsonPath("$.walletNumber").value(WALLET_NUMBER))
                .andExpect(jsonPath("$.token").value(VALID_TOKEN));
    }

    @Test
    @DisplayName("Sign in into account with email and password")
    void signIn() throws Exception {
        SignInResponse signInResponse = buildSignInResponse();
        SignInRequest signInRequest = buildSignInRequest();

        when(authenticationService.signIn(signInRequest)).thenReturn(signInResponse);

        mockMvc.perform(post("/auth/signin")
                        .content(asJsonString(signInRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(TextResources.LOGIN_SUCCESSFUL.getMessage()))
                .andExpect(jsonPath("$.token").value(VALID_TOKEN));
    }

    private static SignUpResponse buildSignUpResponse() {
        return SignUpResponse.builder()
                .firstName(FIRST_NAME)
                .walletNumber(WALLET_NUMBER)
                .lastName(USER_LAST_NAME)
                .token(VALID_TOKEN)
                .build();
    }

    private static SignUpRequest buildSignUpRequest() {
        return SignUpRequest.builder()
                .firstName(FIRST_NAME)
                .password(USER_PASSWORD)
                .lastName(USER_LAST_NAME)
                .email(USER_EMAIL)
                .build();
    }

    private static SignInResponse buildSignInResponse() {
        return SignInResponse.builder()
                .message(TextResources.LOGIN_SUCCESSFUL.getMessage())
                .token(VALID_TOKEN)
                .build();
    }

    private static SignInRequest buildSignInRequest() {
        return SignInRequest.builder()
                .email(USER_EMAIL)
                .password(USER_PASSWORD)
                .build();
    }

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}