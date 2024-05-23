package ua.lysenko.userserivce.service.implementation;

import com.google.protobuf.Empty;
import common.grpc.users.AllWalletsResponse;
import common.grpc.users.GetWalletByUserIdRequest;
import common.grpc.users.WalletResponse;
import common.grpc.users.WalletServiceGrpc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ua.lysenko.userserivce.textresources.ExceptionKeys;
import ua.lysenko.userserivce.dto.UserDTO;
import ua.lysenko.userserivce.entity.Role;
import ua.lysenko.userserivce.entity.User;
import ua.lysenko.userserivce.exceptions.userexceptions.UserNotFoundException;
import ua.lysenko.userserivce.repository.UsersRepository;
import ua.lysenko.userserivce.service.UserService;
import ua.lysenko.userserivce.shared.MapperUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub;

    public UserServiceImpl(UsersRepository usersRepository, WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub) {
        this.usersRepository = usersRepository;
        this.walletServiceBlockingStub = walletServiceBlockingStub;
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
    public UserDTO getUserDetailsById(Long id, String token) {
        User user = getUserById(id);
        if (SecurityContextHolder.getContext().getAuthentication().getName().equals(user.getEmail())
                || user.getRole().equals(Role.ROLE_ADMIN)) {
            UserDTO userDTO = MapperUtils.map(user, UserDTO.class);
            GetWalletByUserIdRequest request = GetWalletByUserIdRequest.newBuilder()
                    .setUserID(userDTO.getId())
                    .build();
            WalletResponse response = walletServiceBlockingStub.getWalletByUserId(request);
            userDTO.setWalletNumber(response.getResp().getWalletNumber());
            return userDTO;
        } else {
            throw new UserNotFoundException(ExceptionKeys.NO_ACCESS_TO_THE_CONTENT.getMessage().toString());
        }
    }

    @Override
    public List<UserDTO> getAllUsers(Pageable pageable) {
        List<UserDTO> users = usersRepository.findAll(pageable)
                .stream()
                .map(user -> MapperUtils.map(user, UserDTO.class))
                .toList();
        AllWalletsResponse response = walletServiceBlockingStub.getAllWallets(Empty.getDefaultInstance());
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
        return MapperUtils.map(user, UserDTO.class);
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
    public void updateUserSuspiciousActivity(Long userId) {
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
}
