package ua.lysenko.service.userservice;

import com.google.protobuf.Empty;
import common.grpc.users.*;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import ua.lysenko.userservice.dto.UserDTO;
import ua.lysenko.userservice.entity.Role;
import ua.lysenko.userservice.entity.User;
import ua.lysenko.userservice.exceptions.ServiceUnavailableException;
import ua.lysenko.userservice.exceptions.UserNotFoundException;
import ua.lysenko.userservice.repository.UsersRepository;
import ua.lysenko.userservice.service.JwtService;
import ua.lysenko.userservice.service.implementation.UserServiceImpl;
import ua.lysenko.userservice.textresources.ExceptionKeys;
import ua.lysenko.userservice.utils.mappers.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    public static final String WALLET_NUMBER = "1234567890";
    public static final String WALLET_NUMBER_2 = "9876543210";
    public static final String AUTHORIZATION_TOKEN = "dummyToken";
    public static final String USER_EMAIL = "test";
    public static final long USER_ID = 1L;
    public static final long USER_ID_2 = 2L;
    public static final String USER_FIRST_NAME = "John";
    public static final String USER_LAST_NAME = "Doe";
    @Mock
    UsersRepository usersRepository;
    @Mock
    WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserMapper userMapper;
    @Mock
    private Authentication authentication;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("Should throw exception when user is not found by email")
    void testGetUserByInvalidEmailException() {
        when(usersRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.empty());
        UserNotFoundException thrownException =
                assertThrows(UserNotFoundException.class, () -> userService.getUserByEmail(USER_EMAIL));
        assertEquals(String.format(ExceptionKeys.USER_WITH_EMAIL_NOT_FOUND.getMessage(), USER_EMAIL),
                thrownException.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when user is not found by id")
    void testGetUserByInvalidIdException() {
        when(usersRepository.findById(USER_ID)).thenReturn(Optional.empty());
        UserNotFoundException thrownException =
                assertThrows(UserNotFoundException.class, () -> userService.getUserById(USER_ID));
        assertEquals(String.format(ExceptionKeys.USER_WITH_ID_NOT_FOUND.getMessage(), USER_ID),
                thrownException.getMessage());
    }

    @Test
    @DisplayName("Should load wallet number when request is sent by logged in user")
    void testGetUserDetails() {
        User user = buildFirstUser();
        when(jwtService.extractUserName(AUTHORIZATION_TOKEN)).thenReturn(USER_EMAIL);
        when(usersRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.of(user));

        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(authentication.getName()).thenReturn(USER_EMAIL);

        UserDTO userDTO = buildUserDTO(user);
        when(userMapper.toUserDTO(user)).thenReturn(userDTO);
        GetWalletByUserIdRequest request = buildUserWallet(userDTO);
        WalletResponse walletResponse = WalletResponse.
                newBuilder().setResp(
                        WalletMessage.newBuilder()
                                .setWalletNumber(WALLET_NUMBER)
                                .build())
                .build();
        when(walletServiceBlockingStub.getWalletByUserId(request)).thenReturn(walletResponse);
        userDTO = userService.getUserDetails(AUTHORIZATION_TOKEN);
        assertEquals(walletResponse.getResp().getWalletNumber(), userDTO.getWalletNumber());
    }

    @Test
    @DisplayName("Should load list of all users for Admin")
    void testGetAllUsersForAdminRole() {
        User firstUser = buildFirstUser();
        User secondUser = buildSecondUser();
        Pageable pageable = PageRequest.of(1, 10);
        when(usersRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(firstUser, secondUser)));

        UserDTO firstUserDTO = buildUserDTO(firstUser);
        UserDTO secondUserDTO = buildUserDTO1(secondUser);
        when(userMapper.toUserDTO(firstUser)).thenReturn(firstUserDTO);
        when(userMapper.toUserDTO(secondUser)).thenReturn(secondUserDTO);

        WalletMessage firstWalletMessage = WalletMessage
                .newBuilder()
                .setWalletNumber(WALLET_NUMBER).
                setUserId(firstUser.getId())
                .build();
        WalletMessage secondWalletMessage = WalletMessage
                .newBuilder()
                .setWalletNumber(WALLET_NUMBER_2).
                setUserId(secondUser.getId())
                .build();
        List<WalletMessage> walletMessages = new ArrayList<>(List.of(firstWalletMessage, secondWalletMessage));

        AllWalletsResponse allWalletsResponse = AllWalletsResponse.newBuilder()
                .addAllWallets(walletMessages)
                .build();
        when(walletServiceBlockingStub.getAllWallets(Empty.getDefaultInstance())).thenReturn(allWalletsResponse);
        List<UserDTO> response = userService.getAllUsers(pageable);
        assertEquals(firstWalletMessage.getWalletNumber(), response.get(0).getWalletNumber());
        assertEquals(secondWalletMessage.getWalletNumber(), response.get(1).getWalletNumber());
    }

    @Test
    @DisplayName("Should throw exception when wallet service is unavailable")
    void testGetAllUsersException() {
        User firstUser = buildFirstUser();
        User secondUser = buildSecondUser();
        Pageable pageable = PageRequest.of(1, 10);
        when(usersRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(firstUser, secondUser)));

        UserDTO firstUserDTO = buildUserDTO(firstUser);
        UserDTO secondUserDTO = buildUserDTO1(secondUser);
        when(userMapper.toUserDTO(firstUser)).thenReturn(firstUserDTO);
        when(userMapper.toUserDTO(secondUser)).thenReturn(secondUserDTO);

        when(walletServiceBlockingStub.getAllWallets(Empty.getDefaultInstance())).thenThrow(StatusRuntimeException.class);

        ServiceUnavailableException thrownException =
                assertThrows(ServiceUnavailableException.class, () -> userService.getAllUsers(pageable));
        assertEquals(thrownException.getMessage(), ExceptionKeys.SERVICE_UNAVAILABLE.getMessage());
    }

    @Test
    @DisplayName("Should update role to Admin")
    void testUpdateUserRole() {
        User user = buildFirstUser();
        when(usersRepository.findByEmail(USER_EMAIL)).thenReturn(Optional.ofNullable(user));
        when(userMapper.toUserDTO(user)).thenReturn(new UserDTO());

        userService.updateUserAdminRole(USER_EMAIL);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(usersRepository, times(1)).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();

        assertEquals(Role.ROLE_ADMIN, savedUser.getRole());
    }

    @Test
    @DisplayName("Should mark user as suspicious")
    void testUpdateUserSuspiciousActivity() {
        User user = buildFirstUser();
        when(usersRepository.findById(USER_ID)).thenReturn(Optional.ofNullable(user));

        userService.updateUserSuspiciousActivityById(USER_ID);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(usersRepository, times(1)).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();

        assertTrue(savedUser.isSuspiciousActivityDetected());
    }

    @Test
    @DisplayName("Should mark user as suspicious")
    void testBlockUser() {
        User user = buildFirstUser();
        when(usersRepository.findById(USER_ID)).thenReturn(Optional.ofNullable(user));

        userService.blockUserById(USER_ID);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(usersRepository, times(1)).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();

        assertTrue(savedUser.isTransactionBlocked());
    }
    @Test
    @DisplayName("Should unblock user by Id")
    void testUnblockUser() {
        User user = buildFirstUser();
        when(usersRepository.findById(USER_ID)).thenReturn(Optional.ofNullable(user));

        userService.unblockUserById(USER_ID);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(usersRepository, times(1)).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();

        assertFalse(savedUser.isTransactionBlocked());
    }

    private static GetWalletByUserIdRequest buildUserWallet(UserDTO userDTO) {
        return GetWalletByUserIdRequest.newBuilder()
                .setUserID(userDTO.getId())
                .build();
    }

    private static User buildFirstUser() {
        return User.builder()
                .id(USER_ID)
                .email(USER_EMAIL)
                .role(Role.ROLE_USER)
                .firstName(USER_FIRST_NAME)
                .lastName(USER_LAST_NAME)
                .build();
    }

    private static User buildSecondUser() {
        return User.builder()
                .id(USER_ID_2)
                .email(USER_EMAIL)
                .role(Role.ROLE_USER)
                .firstName(USER_FIRST_NAME)
                .lastName(USER_LAST_NAME)
                .build();
    }

    private static UserDTO buildUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    private static UserDTO buildUserDTO1(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
