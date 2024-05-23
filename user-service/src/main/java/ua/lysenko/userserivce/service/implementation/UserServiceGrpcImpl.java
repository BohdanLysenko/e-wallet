package ua.lysenko.userserivce.service.implementation;

import com.google.protobuf.Empty;
import common.grpc.users.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import ua.lysenko.userserivce.entity.User;
import ua.lysenko.userserivce.service.JwtService;
import ua.lysenko.userserivce.service.UserService;

@GRpcService
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {

    private final JwtService jwtService;
    private final UserService userService;

    public UserServiceGrpcImpl(JwtService jwtService, ua.lysenko.userserivce.service.UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public void getUserDetails(UserTokenRequest request, StreamObserver<UserDetailsMessage> responseObserver) {
        String token = request.getToken();
        token = token.replace("Bearer ", "");
        String email = jwtService.extractUserName(token);
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
        userService.updateUserSuspiciousActivity(request.getId());
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUserTransactionBlocked(UserDisabledRequest request, StreamObserver<Empty> responseObserver) {
        userService.disableUser(request.getId());
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
