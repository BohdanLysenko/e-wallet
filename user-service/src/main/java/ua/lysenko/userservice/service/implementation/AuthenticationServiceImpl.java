package ua.lysenko.userservice.service.implementation;

import common.grpc.users.*;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ua.lysenko.userservice.entity.Role;
import ua.lysenko.userservice.entity.User;
import ua.lysenko.userservice.exceptions.NonUniqueEmailException;
import ua.lysenko.userservice.exceptions.InvalidPasswordException;
import ua.lysenko.userservice.exceptions.ServiceUnavailableException;
import ua.lysenko.userservice.repository.UsersRepository;
import ua.lysenko.userservice.service.AuthenticationService;
import ua.lysenko.userservice.service.JwtService;
import ua.lysenko.userservice.service.UserService;
import ua.lysenko.userservice.shared.PasswordUtils;
import ua.lysenko.userservice.textresources.ExceptionKeys;
import ua.lysenko.userservice.textresources.TextResources;
import ua.lysenko.userservice.ui.models.SignInRequest;
import ua.lysenko.userservice.ui.models.SignInResponse;
import ua.lysenko.userservice.ui.models.SignUpRequest;
import ua.lysenko.userservice.ui.models.SignUpResponse;
import ua.lysenko.userservice.validators.SignUpEmailValidator;
import ua.lysenko.userservice.validators.SignUpPasswordValidator;

import static ua.lysenko.userservice.textresources.ExceptionKeys.EMAIL_IS_NOT_UNIQUE;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UsersRepository usersRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub;

    private final SignUpPasswordValidator signUpPasswordValidator;
    private final SignUpEmailValidator signUpEmailValidator;

    private final UserService userService;

    Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    public AuthenticationServiceImpl(UsersRepository usersRepository,
                                     JwtService jwtService,
                                     AuthenticationManager authenticationManager,
                                     WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub,
                                     SignUpPasswordValidator signUpPasswordValidator,
                                     SignUpEmailValidator signUpEmailValidator,
                                     UserService userService) {
        this.usersRepository = usersRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.walletServiceBlockingStub = walletServiceBlockingStub;
        this.signUpPasswordValidator = signUpPasswordValidator;
        this.signUpEmailValidator = signUpEmailValidator;
        this.userService = userService;
    }

    @Override
    public SignUpResponse signUp(SignUpRequest request) {
        if (!signUpEmailValidator.isValid(request)) {
            throw new NonUniqueEmailException(EMAIL_IS_NOT_UNIQUE.getMessage());
        }
        if (!signUpPasswordValidator.isValid(request)) {
            throw new InvalidPasswordException(ExceptionKeys.PASSWORD_IS_INVALID.getMessage());
        }
        try {
            checkWalletServiceAvailability();
        } catch (StatusRuntimeException statusRuntimeException){
            throw new ServiceUnavailableException(ExceptionKeys.SERVICE_UNAVAILABLE.getMessage());
        }
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .encryptedPassword(PasswordUtils.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .isSuspiciousActivityDetected(false)
                .isTransactionBlocked(false)
                .enabled(true)
                .build();
        user = usersRepository.save(user);
        String walletNumber = createUserWallet(user);
        String jwt = jwtService.generateToken(user);
        return SignUpResponse.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .walletNumber(walletNumber)
                .token(jwt)
                .build();
    }

    @Override
    public SignInResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userService.getUserByEmail(request.getEmail());
        String jwt = jwtService.generateToken(user);
        return SignInResponse.builder()
                .token(jwt)
                .message(TextResources.LOGIN_SUCCESSFUL.getMessage())
                .build();
    }

    private void checkWalletServiceAvailability() {
        HealthCheckRequest healthCheckRequest = HealthCheckRequest.newBuilder()
                .build();
        HealthCheckResponse response = walletServiceBlockingStub.check(healthCheckRequest);
    }

    private String createUserWallet(User user) {
        WalletResponse createWalletResponse = walletServiceBlockingStub.createWallet(CreateWalletRequest
                .newBuilder()
                .setUserId(user.getId())
                .build());
        return createWalletResponse.getResp().getWalletNumber();
    }
}