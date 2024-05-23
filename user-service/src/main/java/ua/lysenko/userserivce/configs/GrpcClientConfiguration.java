package ua.lysenko.userserivce.configs;

import common.grpc.users.WalletServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GrpcClientConfiguration {

    @Bean
    WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub() {
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 6575)
                .usePlaintext()
                .build();

        return WalletServiceGrpc.newBlockingStub(channel);
    }
}