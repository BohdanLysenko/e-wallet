package ua.lysenko.userservice.service.implementation;

import com.google.protobuf.Empty;
import common.grpc.users.*;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.lognet.springboot.grpc.GRpcService;
import ua.lysenko.userservice.entity.User;
import ua.lysenko.userservice.service.JwtService;
import ua.lysenko.userservice.service.UserService;

@GRpcService
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {

    private final JwtService jwtService;
    private final UserService userService;

    public UserServiceGrpcImpl(JwtService jwtService, ua.lysenko.userservice.service.UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public void getUserDetails(UserTokenRequest request, StreamObserver<UserDetailsMessage> responseObserver) {
        String token = request.getToken();
        token = token.replace("Bearer ", "");
        String email = "";
        try {
            email = jwtService.extractUserName(token);
        } catch (ExpiredJwtException exception) {
            responseObserver.onError(new StatusRuntimeException(Status.UNAUTHENTICATED));
        } catch (MalformedJwtException | SignatureException exception) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        }
        User user = userService.getUserByEmail(email);
        if (jwtService.isTokenValid(token, user)) {
            UserDetailsMessage userDetailsResponse = UserDetailsMessage
                    .newBuilder().setResp(UserMessage
                            .newBuilder()
                            .setEmail(user.getEmail())
                            .setTransactionBlocked(user.isTransactionBlocked())
                            .setId(user.getId())
                            .setRole(user.getRole().name())
                            .setFirstName(user.getFirstName())
                            .setLastName(user.getLastName())
                            .setSuspiciousActivityDetected(user.isSuspiciousActivityDetected())
                            .build())
                    .build();
            responseObserver.onNext(userDetailsResponse);
            responseObserver.onCompleted();
        }
        responseObserver.onCompleted();
    }

    @Override
    public void updateUserSuspiciousActivity(UserSuspiciousRequest request, StreamObserver<Empty> responseObserver) {
        userService.updateUserSuspiciousActivityById(request.getId());
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUserTransactionBlocked(UserDisabledRequest request, StreamObserver<Empty> responseObserver) {
        userService.blockUserById(request.getId());
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void unblockAllUsers(UserUnblockRequest request, StreamObserver<UserUnblockResponse> responseObserver) {
        userService.unblockAllUsers();
        UserUnblockResponse response = UserUnblockResponse.newBuilder()
                .setSuccess(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
