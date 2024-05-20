package ua.lysenko.banking.config;

import common.grpc.Users.UserServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GrpcClientConfiguration {

    @Bean
    UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub() {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 6570)
                .usePlaintext()
                .build();

        return UserServiceGrpc.newBlockingStub(channel);
    }
}