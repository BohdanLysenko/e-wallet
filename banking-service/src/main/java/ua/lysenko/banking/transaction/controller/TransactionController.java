package ua.lysenko.banking.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.CreatePaymentTransactionRequestModel;
import ua.lysenko.banking.transaction.models.CreateTransferTransactionRequestModel;
import ua.lysenko.banking.transaction.service.TransactionServiceContext;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.CreateTransactionRequestModel;
import ua.lysenko.banking.transaction.models.TransactionResponseModel;
import ua.lysenko.banking.utils.Mappers.TransactionContextMapper;
import ua.lysenko.banking.utils.Mappers.TransactionControllerMapper;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionServiceContext transactionContext;

    private final TransactionContextMapper transactionContextMapper;
    private final TransactionControllerMapper transactionControllerMapper;

    public TransactionController(TransactionServiceContext transactionContext, TransactionContextMapper transactionContextMapper, TransactionControllerMapper transactionControllerMapper) {
        this.transactionContext = transactionContext;
        this.transactionContextMapper = transactionContextMapper;
        this.transactionControllerMapper = transactionControllerMapper;
    }

    @PostMapping(value = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionResponseModel> deposit(@RequestHeader("Authorization") String authorizationHeader,
                                                            @RequestBody CreateTransactionRequestModel request) {
        TransactionDTO transactionDTO = transactionControllerMapper.toTransactionDTO(request);
        TransactionResponseModel response = transactionContextMapper.toTransactionResponseModel(
                transactionContext.processTransaction(authorizationHeader,
                        transactionDTO, TransactionType.DEPOSIT));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/withdraw", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionResponseModel> withdraw(@RequestHeader("Authorization") String authorizationHeader,
                                                             @RequestBody CreateTransactionRequestModel request) {
        TransactionDTO transactionDTO = transactionControllerMapper.toTransactionDTO(request);
        TransactionResponseModel response = transactionContextMapper.toTransactionResponseModel(
                transactionContext.processTransaction(authorizationHeader,
                        transactionDTO, TransactionType.WITHDRAWAL));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionResponseModel> transfer(@RequestHeader("Authorization") String authorizationHeader,
                                                             @RequestBody
                                                             CreateTransferTransactionRequestModel request) {
        TransactionDTO transactionDTO = transactionControllerMapper.toTransactionDTO(request);
        TransactionResponseModel response = transactionContextMapper.toTransactionResponseModel(
                transactionContext.processTransaction(authorizationHeader,
                        transactionDTO, TransactionType.TRANSFER));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionResponseModel> pay(@RequestHeader("Authorization") String authorizationHeader,
                                                        @RequestBody
                                                        CreatePaymentTransactionRequestModel request) {
        TransactionDTO transactionDTO = transactionControllerMapper.toTransactionDTO(request);
        TransactionResponseModel response = transactionContextMapper.toTransactionResponseModel(
                transactionContext.processTransaction(authorizationHeader,
                        transactionDTO, TransactionType.PAYMENT));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
