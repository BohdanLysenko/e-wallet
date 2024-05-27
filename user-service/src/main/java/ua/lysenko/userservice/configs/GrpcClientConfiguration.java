package ua.lysenko.userservice.configs;

import common.grpc.users.WalletServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GrpcClientConfiguration {

    @Value("${BANKING_GRPC_HOST}")
    private String grpcHost;
    @Bean
    WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub() {
        Channel channel = ManagedChannelBuilder.forAddress(grpcHost, 6575)
                .usePlaintext()
                .build();

        return WalletServiceGrpc.newBlockingStub(channel);
    }
}