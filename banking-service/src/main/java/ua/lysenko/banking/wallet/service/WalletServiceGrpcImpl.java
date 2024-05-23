package ua.lysenko.banking.wallet.service;

import com.google.protobuf.Empty;
import common.grpc.users.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import ua.lysenko.banking.wallet.dto.WalletDTO;
import ua.lysenko.banking.wallet.repository.WalletRepository;
import ua.lysenko.banking.entity.Wallet;

import java.util.List;
import java.util.stream.Collectors;

@GRpcService
@Slf4j
public class WalletServiceGrpcImpl extends WalletServiceGrpc.WalletServiceImplBase {


    private final WalletService walletService;

    public WalletServiceGrpcImpl(WalletRepository walletRepository, WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public void createWallet(CreateWalletRequest request, StreamObserver<WalletResponse> responseObserver) {
        WalletDTO createdWalletDTO = walletService.createWallet(request.getUserId());
        WalletResponse response = WalletResponse.newBuilder()
                .setResp(WalletMessage.newBuilder()
                        .setWalletId(createdWalletDTO.getId())
                        .setWalletNumber(createdWalletDTO.getWalletNumber())
                        .setUserId(createdWalletDTO.getUserId()).build())

                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getWalletByUserId(GetWalletByUserIdRequest request, StreamObserver<WalletResponse> responseObserver) {
        Wallet createdWallet = walletService.getWalletByUserId(request.getUserID());
        WalletResponse getWalletByUserIdResponse = WalletResponse
                .newBuilder()
                .setResp(WalletMessage.newBuilder()
                        .setWalletId(createdWallet.getId())
                        .setWalletNumber(createdWallet.getWalletNumber().toString())
                        .build()
                ).build();
        responseObserver.onNext(getWalletByUserIdResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void check(HealthCheckRequest request, StreamObserver<HealthCheckResponse> responseObserver) {
        HealthCheckResponse response = HealthCheckResponse.newBuilder()
                .setHealthy(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllWallets(Empty request, StreamObserver<AllWalletsResponse> responseObserver) {
        List<WalletMessage> wallets = walletService.getAllWallets().stream()
                .map(wallet -> WalletMessage.newBuilder()
                        .setWalletId(wallet.getId())
                        .setWalletNumber(wallet.getWalletNumber().toString())
                        .setUserId(wallet.getUserId())
                        .build())
                .toList();
        AllWalletsResponse response = AllWalletsResponse.newBuilder()
                .addAllWallets(wallets)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
