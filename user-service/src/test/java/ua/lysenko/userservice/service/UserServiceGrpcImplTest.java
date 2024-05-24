package ua.lysenko.service.userservice;

import com.google.protobuf.Empty;
import common.grpc.users.*;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.lysenko.userservice.entity.Role;
import ua.lysenko.userservice.entity.User;
import ua.lysenko.userservice.service.JwtService;
import ua.lysenko.userservice.service.UserService;
import ua.lysenko.userservice.service.implementation.UserServiceGrpcImpl;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceGrpcImplTest {

    public static final String VALID_TOKEN = "valid_token";
    public static final String INVALID_TOKEN = "invalid_token";
    public static final String VALID_EMAIL = "test@example.com";
    @Mock
    private UserService userService;

    @Mock
    private JwtService jwtService;

    @Mock
    private StreamObserver<UserDetailsMessage> userDetailsMessageStreamObserver;
    @Mock
    private StreamObserver<UserUnblockResponse> unblockResponseStreamObserver;
    @Mock
    private StreamObserver<Empty> emptyStreamObserver;
    @InjectMocks
    UserServiceGrpcImpl userServiceGrpc;

    @Test
    @DisplayName("getUserDetails() should return UserMessage with the correct credential provided")
    public void testGetUserDetails() {
        User user = buildUser(VALID_EMAIL);
        when(jwtService.extractUserName(VALID_TOKEN)).thenReturn(VALID_EMAIL);
        when(userService.getUserByEmail(VALID_EMAIL)).thenReturn(user);
        when(jwtService.isTokenValid(VALID_TOKEN, user)).thenReturn(true);

        UserTokenRequest request = UserTokenRequest.newBuilder().
                setToken(VALID_TOKEN)
                .build();
        userServiceGrpc.getUserDetails(request, userDetailsMessageStreamObserver);

        // Assert
        verify(userDetailsMessageStreamObserver).onNext(any());
        verify(userDetailsMessageStreamObserver, times(2)).onCompleted();
    }

    @Test
    @DisplayName("getUserDetails() should throw an error for incorrect credentials")
    public void testGetUserDetailsException() {
        when(jwtService.extractUserName(INVALID_TOKEN)).thenThrow(ExpiredJwtException.class);

        UserTokenRequest request = UserTokenRequest.newBuilder().
                setToken(INVALID_TOKEN)
                .build();
        userServiceGrpc.getUserDetails(request, userDetailsMessageStreamObserver);

        verify(userDetailsMessageStreamObserver).onError(any());
        verify(userDetailsMessageStreamObserver).onCompleted();
    }

    @Test
    @DisplayName("User should be marked as suspicious when UserSuspiciousRequest is received")
    public void testUpdateUserSuspiciousActivity() {
        UserSuspiciousRequest request = UserSuspiciousRequest.newBuilder()
                .build();

        userServiceGrpc.updateUserSuspiciousActivity(request, emptyStreamObserver);

        verify(emptyStreamObserver).onCompleted();
        verify(emptyStreamObserver).onNext(any());
    }
    @Test
    @DisplayName("User should be blocked from transactions when UserDisabledRequest is received")
    public void testUnblockUser() {
        UserDisabledRequest request = UserDisabledRequest.newBuilder()
                .build();

        userServiceGrpc.updateUserTransactionBlocked(request, emptyStreamObserver);

        verify(emptyStreamObserver).onCompleted();
        verify(emptyStreamObserver).onNext(any());
    }
    @Test
    @DisplayName("All users should be unblocked from transactions when UserUnblockRequest is received")
    public void testUnblockAllUsers() {
        UserUnblockRequest request = UserUnblockRequest.newBuilder()
                .build();

        userServiceGrpc.unblockAllUsers(request, unblockResponseStreamObserver);

        verify(unblockResponseStreamObserver).onCompleted();
        verify(unblockResponseStreamObserver).onNext(any());
    }

    private static User buildUser(String email) {
        return User.builder()
                .email(email)
                .id(1L)
                .isTransactionBlocked(false)
                .firstName("John")
                .lastName("Doe")
                .isSuspiciousActivityDetected(false)
                .role(Role.ROLE_USER)
                .build();
    }

}