package ua.lysenko.quartzservice.config;

import common.grpc.users.UserServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GrpcClientConfiguration {

    @Value("${USERS_GRPC_HOST}")
    private String grpcHost;
    @Bean
    UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub() {
        Channel channel = ManagedChannelBuilder.forAddress(grpcHost, 6570)
                .usePlaintext()
                .build();

        return UserServiceGrpc.newBlockingStub(channel);
    }
}