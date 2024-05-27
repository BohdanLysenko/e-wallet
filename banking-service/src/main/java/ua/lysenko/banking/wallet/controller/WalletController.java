package ua.lysenko.banking.wallet.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lysenko.banking.utils.mappers.WalletMapper;
import ua.lysenko.banking.wallet.models.WalletResponseModel;
import ua.lysenko.banking.wallet.service.WalletService;


@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;
    private final WalletMapper walletMapper;

    public WalletController(WalletService walletService, WalletMapper walletMapper) {
        this.walletService = walletService;
        this.walletMapper = walletMapper;
    }

    @GetMapping
    @Operation(summary = "Get wallet with attached Card for Current User")
    public ResponseEntity<WalletResponseModel> getWallet(@RequestHeader("Authorization") String token) {
        WalletResponseModel retVal = walletMapper.toWalletResponseModel(walletService.getWalletByToken(token));
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deactivate wallet with all attached cards for current User")
    public ResponseEntity<Void> deleteWallet(@RequestHeader("Authorization") String token) {
        walletService.deleteWallet(token);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
