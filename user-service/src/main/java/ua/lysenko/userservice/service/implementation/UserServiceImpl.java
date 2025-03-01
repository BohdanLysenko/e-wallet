package ua.lysenko.userservice.service.implementation;

import com.google.protobuf.Empty;
import common.grpc.users.AllWalletsResponse;
import common.grpc.users.GetWalletByUserIdRequest;
import common.grpc.users.WalletResponse;
import common.grpc.users.WalletServiceGrpc;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ua.lysenko.userservice.dto.UserDTO;
import ua.lysenko.userservice.entity.Role;
import ua.lysenko.userservice.entity.User;
import ua.lysenko.userservice.exceptions.ServiceUnavailableException;
import ua.lysenko.userservice.exceptions.UserNotFoundException;
import ua.lysenko.userservice.exceptions.WalletNotFoundException;
import ua.lysenko.userservice.repository.UsersRepository;
import ua.lysenko.userservice.service.JwtService;
import ua.lysenko.userservice.service.UserService;
import ua.lysenko.userservice.textresources.ExceptionKeys;
import ua.lysenko.userservice.utils.mappers.UserMapper;

import java.util.List;

@Service
@Transactional
@Primary
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub;

    private final UserMapper userMapper;

    private final JwtService jwtService;

    public UserServiceImpl(UsersRepository usersRepository, WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub, UserMapper userMapper, JwtService jwtService) {
        this.usersRepository = usersRepository;
        this.walletServiceBlockingStub = walletServiceBlockingStub;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    @Override
    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format(ExceptionKeys.USER_WITH_EMAIL_NOT_FOUND.getMessage(), email)));
    }

    @Override
    public User getUserById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format(ExceptionKeys.USER_WITH_ID_NOT_FOUND.getMessage(), id)));
    }

    @Override
    public UserDTO getUserDetails(String token) {
        token = token.replace("Bearer ", "");
        String email = jwtService.extractUserName(token);
        if (SecurityContextHolder.getContext().getAuthentication().getName().equals(email)) {
            User user = getUserByEmail(email);
            UserDTO userDTO = userMapper.toUserDTO(user);
            GetWalletByUserIdRequest request = GetWalletByUserIdRequest.newBuilder()
                    .setUserID(userDTO.getId())
                    .build();
            WalletResponse response;
            try {
                response = walletServiceBlockingStub.getWalletByUserId(request);
            } catch (StatusRuntimeException statusRuntimeException) {
                if (statusRuntimeException.getStatus().equals(Status.UNAUTHENTICATED)) {
                    throw new WalletNotFoundException(ExceptionKeys.NO_ACTIVE_WALLETS.getMessage());
                }
                throw new ServiceUnavailableException(ExceptionKeys.SERVICE_UNAVAILABLE.getMessage());
            }
            userDTO.setWalletNumber(response.getResp().getWalletNumber());
            return userDTO;
        } else {
            throw new UserNotFoundException(ExceptionKeys.NO_ACCESS_TO_THE_CONTENT.getMessage());
        }
    }

    @Override
    public List<UserDTO> getAllUsers(Pageable pageable) {
        List<UserDTO> users = usersRepository.findAll(pageable)
                .stream()
                .map(userMapper::toUserDTO)
                .toList();
        AllWalletsResponse response;
        try {
            response = walletServiceBlockingStub.getAllWallets(Empty.getDefaultInstance());
        } catch (StatusRuntimeException statusRuntimeException) {
            throw new ServiceUnavailableException(ExceptionKeys.SERVICE_UNAVAILABLE.getMessage());
        }
        for (UserDTO user : users) {
            response.getWalletsList().stream()
                    .filter(wallet -> wallet.getUserId() == user.getId())
                    .findFirst()
                    .ifPresent(wallet -> user.setWalletNumber(wallet.getWalletNumber()));
        }
        return users;
    }

    @Override
    public UserDTO updateUserAdminRole(String email) {
        User user = getUserByEmail(email);
        user.setRole(Role.ROLE_ADMIN);
        usersRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) {
                return usersRepository.findByEmail(email)
                        .orElseThrow(() -> new UserNotFoundException(
                                String.format(ExceptionKeys.USER_WITH_EMAIL_NOT_FOUND.getMessage(), email)));
            }
        };
    }

    @Override
    public void updateUserSuspiciousActivityById(Long userId) {
        User user = getUserById(userId);
        user.setSuspiciousActivityDetected(true);
        usersRepository.save(user);
    }

    @Override
    public void blockUserById(Long userId) {
        User user = getUserById(userId);
        user.setTransactionBlocked(true);
        usersRepository.save(user);
    }

    @Override
    public void unblockUserById(Long userId) {
        User user = getUserById(userId);
        user.setTransactionBlocked(false);
        usersRepository.save(user);
    }

    @Override
    public void unblockAllUsers() {
        usersRepository.unblockAllBlockedUsers();
    }
}
