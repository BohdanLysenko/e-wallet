package ua.lysenko.service.userservice;

import common.grpc.users.HealthCheckRequest;
import common.grpc.users.WalletMessage;
import common.grpc.users.WalletResponse;
import common.grpc.users.WalletServiceGrpc;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import ua.lysenko.userservice.entity.Role;
import ua.lysenko.userservice.entity.User;
import ua.lysenko.userservice.exceptions.NonUniqueEmailException;
import ua.lysenko.userservice.exceptions.ServiceUnavailableException;
import ua.lysenko.userservice.exceptions.UserNotFoundException;
import ua.lysenko.userservice.repository.UsersRepository;
import ua.lysenko.userservice.service.JwtService;
import ua.lysenko.userservice.service.UserService;
import ua.lysenko.userservice.service.implementation.AuthenticationServiceImpl;
import ua.lysenko.userservice.shared.PasswordUtils;
import ua.lysenko.userservice.textresources.TextResources;
import ua.lysenko.userservice.ui.models.SignInRequest;
import ua.lysenko.userservice.ui.models.SignInResponse;
import ua.lysenko.userservice.ui.models.SignUpRequest;
import ua.lysenko.userservice.ui.models.SignUpResponse;
import ua.lysenko.userservice.validators.SignUpEmailValidator;
import ua.lysenko.userservice.validators.SignUpPasswordValidator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceImplTest {
    public static final String WALLET_NUMBER = "1234567890";
    public static final String AUTHORIZATION_TOKEN = "dummyToken";
    @Mock
    private UsersRepository usersRepository;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub;
    @Mock
    private SignUpPasswordValidator signUpPasswordValidator;
    @Mock
    private SignUpEmailValidator signUpEmailValidator;
    @Mock
    private UserService userService;
    @InjectMocks
    AuthenticationServiceImpl authenticationService;

    @Test
    @DisplayName("User should be able to sign up with valid credentials")
    void testSignUp() {
        SignUpRequest request = buildSignUpRequest();

        when(signUpEmailValidator.isValid(request)).thenReturn(true);
        when(signUpPasswordValidator.isValid(request)).thenReturn(true);

        User user = buildUser(request);

        when(usersRepository.save(any())).thenReturn(user);

        WalletResponse walletResponse = WalletResponse.newBuilder()
                .setResp(WalletMessage.newBuilder()
                        .setWalletNumber(WALLET_NUMBER))
                .build();

        when(walletServiceBlockingStub.createWallet(any())).thenReturn(walletResponse);
        when(jwtService.generateToken(any())).thenReturn(AUTHORIZATION_TOKEN);

        SignUpResponse response = authenticationService.signUp(request);

        assertNotNull(response);
        assertEquals(request.getFirstName(), response.getFirstName());
        assertEquals(request.getLastName(), response.getLastName());
        assertEquals(WALLET_NUMBER, response.getWalletNumber());
        assertEquals(AUTHORIZATION_TOKEN, response.getToken());
    }

    @Test
    @DisplayName("Sign Up should throw exception when creating user with duplicate email")
    void testSignUpDuplicateEmailException() {
        SignUpRequest request = buildSignUpRequest();

        when(signUpEmailValidator.isValid(request)).thenReturn(false);

        assertThrows(NonUniqueEmailException.class, () -> authenticationService.signUp(request));
    }

    @Test
    @DisplayName("Sign Up should throw exception when wallet service is down")
    void testSignUpWalletServiceUnavailableException() {
        SignUpRequest request = buildSignUpRequest();
        HealthCheckRequest healthCheckRequest = HealthCheckRequest.newBuilder()
                .build();

        when(signUpEmailValidator.isValid(request)).thenReturn(true);
        when(signUpPasswordValidator.isValid(request)).thenReturn(true);
        when(walletServiceBlockingStub.check(healthCheckRequest)).thenThrow(StatusRuntimeException.class);

        assertThrows(ServiceUnavailableException.class, () -> authenticationService.signUp(request));
    }

    @Test
    @DisplayName("User should be able to log in with valid credentials")
    void testSignIn() {
        SignInRequest request = buildSignInRequest();
        User user = buildUser(request);
        when(userService.getUserByEmail(request.getEmail())).thenReturn(user);
        when(jwtService.generateToken(any(User.class))).thenReturn(AUTHORIZATION_TOKEN);

        SignInResponse response = authenticationService.signIn(request);

        assertNotNull(response);
        assertEquals(AUTHORIZATION_TOKEN, response.getToken());
        assertEquals(TextResources.LOGIN_SUCCESSFUL.getMessage(), response.getMessage());

        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(userService).getUserByEmail(request.getEmail());
        verify(jwtService).generateToken(user);
    }

    @Test
    @DisplayName("User should not be able to log in with invalid credentials")
    void testSignInException() {
        SignInRequest request = buildSignInRequest();
        when(userService.getUserByEmail(request.getEmail())).thenThrow(UserNotFoundException.class);

        assertThrows(UserNotFoundException.class, () -> authenticationService.signIn(request));

        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(jwtService, never()).generateToken(any(User.class));
    }

    private static SignUpRequest buildSignUpRequest() {
        return SignUpRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("12345")
                .build();
    }

    private static SignInRequest buildSignInRequest() {
        return SignInRequest.builder()
                .email("john@example.com")
                .password("password")
                .build();
    }

    private static User buildUser(SignUpRequest request) {
        return User.builder()
                .id(1L)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .encryptedPassword(PasswordUtils.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .isSuspiciousActivityDetected(false)
                .isTransactionBlocked(false)
                .enabled(true)
                .build();
    }

    private static User buildUser(SignInRequest request) {
        return User.builder()
                .id(1L)
                .email(request.getEmail())
                .role(Role.ROLE_USER)
                .isSuspiciousActivityDetected(false)
                .isTransactionBlocked(false)
                .enabled(true)
                .build();
    }
}
