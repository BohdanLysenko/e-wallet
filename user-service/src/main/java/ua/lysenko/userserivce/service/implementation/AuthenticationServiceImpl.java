package ua.lysenko.userserivce.service.implementation;

import common.grpc.users.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ua.lysenko.userserivce.entity.Role;
import ua.lysenko.userserivce.entity.User;
import ua.lysenko.userserivce.exceptions.NonUniqueEmailException;
import ua.lysenko.userserivce.exceptions.userexceptions.InvalidPasswordException;
import ua.lysenko.userserivce.repository.UsersRepository;
import ua.lysenko.userserivce.service.AuthenticationService;
import ua.lysenko.userserivce.service.JwtService;
import ua.lysenko.userserivce.service.UserService;
import ua.lysenko.userserivce.shared.PasswordUtils;
import ua.lysenko.userserivce.textresources.ExceptionKeys;
import ua.lysenko.userserivce.textresources.TextResources;
import ua.lysenko.userserivce.ui.models.SignInRequest;
import ua.lysenko.userserivce.ui.models.SignInResponse;
import ua.lysenko.userserivce.ui.models.SignUpRequest;
import ua.lysenko.userserivce.ui.models.SignUpResponse;
import ua.lysenko.userserivce.validators.SignUpEmailValidator;
import ua.lysenko.userserivce.validators.SignUpPasswordValidator;

import static ua.lysenko.userserivce.textresources.ExceptionKeys.EMAIL_IS_NOT_UNIQUE;

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
            logger.error(String.format(
                            ExceptionKeys.INVALID_PASSWORD_PATTERN.getMessage()),
                    request.getEmail());
            throw new InvalidPasswordException(ExceptionKeys.PASSWORD_IS_INVALID.getMessage());
        }
        checkWalletServiceAvailability();
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