package ua.lysenko.banking.transaction.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.CreatePaymentTransactionRequestModel;
import ua.lysenko.banking.transaction.models.CreateTransactionRequestModel;
import ua.lysenko.banking.transaction.models.CreateTransferTransactionRequestModel;
import ua.lysenko.banking.transaction.models.TransactionResponseModel;
import ua.lysenko.banking.transaction.service.TransactionServiceContext;
import ua.lysenko.banking.transaction.service.implementation.TransactionServiceImpl;
import ua.lysenko.banking.utils.mappers.TransactionContextMapper;
import ua.lysenko.banking.utils.mappers.TransactionControllerMapper;
import ua.lysenko.banking.utils.mappers.TransactionMapper;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionServiceContext transactionContext;

    private final TransactionContextMapper transactionContextMapper;
    private final TransactionMapper transactionMapper;
    private final TransactionControllerMapper transactionControllerMapper;
    private final TransactionServiceImpl transactionService;

    public TransactionController(TransactionServiceContext transactionContext,
                                 TransactionContextMapper transactionContextMapper,
                                 TransactionMapper transactionMapper, TransactionControllerMapper transactionControllerMapper,
                                 TransactionServiceImpl transactionService) {
        this.transactionContext = transactionContext;
        this.transactionContextMapper = transactionContextMapper;
        this.transactionMapper = transactionMapper;
        this.transactionControllerMapper = transactionControllerMapper;
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Deposit funds to card by card number")
    public ResponseEntity<TransactionResponseModel> deposit(@RequestHeader("Authorization") String authorizationHeader,
                                                            @RequestBody @Valid
                                                            CreateTransactionRequestModel request) {
        TransactionDTO transactionDTO = transactionControllerMapper.toTransactionDTO(request);
        transactionDTO = transactionContext.processTransaction(authorizationHeader,
                transactionDTO, TransactionType.DEPOSIT);
        // Each time we need to create a new model, so it can be mapped properly as MapStruct can't catch booleans
        // where get method starts with iS (default for builders).
        TransactionResponseModel response = new TransactionResponseModel();
        response = transactionContextMapper.toTransactionResponseModel(transactionDTO,response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/withdraw", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Withdraws funds from card by card number")
    public ResponseEntity<TransactionResponseModel> withdraw(@RequestHeader("Authorization") String authorizationHeader,
                                                             @RequestBody @Valid
                                                             CreateTransactionRequestModel request) {
        TransactionDTO transactionDTO = transactionControllerMapper.toTransactionDTO(request);
        transactionDTO = transactionContext.processTransaction(authorizationHeader,
                transactionDTO, TransactionType.WITHDRAWAL);
        TransactionResponseModel response = new TransactionResponseModel();
        response = transactionContextMapper.toTransactionResponseModel(transactionDTO,response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Transfer funds between cards")
    public ResponseEntity<TransactionResponseModel> transfer(@RequestHeader("Authorization") String authorizationHeader,
                                                             @RequestBody @Valid
                                                             CreateTransferTransactionRequestModel request) {
        TransactionDTO transactionDTO = transactionControllerMapper.toTransactionDTO(request);
        transactionDTO = transactionContext.processTransaction(authorizationHeader,
                transactionDTO, TransactionType.TRANSFER);
        TransactionResponseModel response = new TransactionResponseModel();
        response = transactionContextMapper.toTransactionResponseModel(transactionDTO,response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Send payment to external Merchant")
    public ResponseEntity<TransactionResponseModel> pay(@RequestHeader("Authorization") String authorizationHeader,
                                                        @RequestBody @Valid
                                                        CreatePaymentTransactionRequestModel request) {
        TransactionDTO transactionDTO = transactionControllerMapper.toTransactionDTO(request);
        transactionDTO = transactionContext.processTransaction(authorizationHeader,
                transactionDTO, TransactionType.PAYMENT);
        TransactionResponseModel response = new TransactionResponseModel();
        response = transactionContextMapper.toTransactionResponseModel(transactionDTO,response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/all")
    @Operation(summary = "Get list of all transactions")
    public ResponseEntity<List<TransactionResponseModel>> getAllTransactionsByCardNumber(@RequestHeader("Authorization")
                                                                             String authorizationHeader,
                                                                             @RequestParam String cardNumber,
                                                                             @RequestParam(defaultValue = "0")
                                                                             Integer pageNumber,
                                                                             @RequestParam(defaultValue = "20")
                                                                             Integer pageSize) {

        List<TransactionResponseModel> response = transactionMapper.transactionsDTOToTransactionsResponseModel(
                transactionService.getAllTransactionsByCardId(authorizationHeader, cardNumber,
                        PageRequest.of(pageNumber, pageSize)));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
