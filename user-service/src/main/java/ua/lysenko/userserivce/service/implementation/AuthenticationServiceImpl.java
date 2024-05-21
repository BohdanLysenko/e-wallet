package ua.lysenko.userserivce.service.implementation;

import common.grpc.Users.CreateWalletRequest;
import common.grpc.Users.WalletResponse;
import common.grpc.Users.WalletServiceGrpc;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lysenko.userserivce.entity.Role;
import ua.lysenko.userserivce.entity.User;
import ua.lysenko.userserivce.exceptions.userexceptions.InvalidPasswordException;
import ua.lysenko.userserivce.repository.UsersRepository;
import ua.lysenko.userserivce.service.AuthenticationService;
import ua.lysenko.userserivce.service.JwtService;
import ua.lysenko.userserivce.shared.PasswordUtils;
import ua.lysenko.userserivce.textresources.ExceptionKeys;
import ua.lysenko.userserivce.ui.models.SignInRequest;
import ua.lysenko.userserivce.ui.models.SignInResponse;
import ua.lysenko.userserivce.ui.models.SignUpRequest;
import ua.lysenko.userserivce.ui.models.SignUpResponse;
import ua.lysenko.userserivce.validators.SignUpRequestValidator;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UsersRepository usersRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub;

    Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public SignUpResponse signup(SignUpRequest request) {
        if (!new SignUpRequestValidator().isValid(request)) {
            logger.error("Invalid password upon signup for user: " + request.getEmail());
            throw new InvalidPasswordException(ExceptionKeys.PASSWORD_IS_INVALID.getMessage());
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
    public SignInResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        //ToDo
        User user = usersRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        String jwt = jwtService.generateToken(user);
        return SignInResponse.builder()
                .token(jwt)
                .build();
    }

    private String createUserWallet(User user) {
        WalletResponse createWalletResponse = walletServiceBlockingStub.createWallet(CreateWalletRequest
                .newBuilder()
                .setUserId(user.getId())
                .build());
        return createWalletResponse.getResp().getWalletNumber();
    }
}