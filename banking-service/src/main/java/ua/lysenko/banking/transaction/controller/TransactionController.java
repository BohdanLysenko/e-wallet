package ua.lysenko.banking.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.service.TransactionServiceContext;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.CreateTransactionRequestModel;
import ua.lysenko.banking.transaction.models.TransactionResponseModel;
import ua.lysenko.banking.utils.MapperUtils;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionServiceContext transactionContext;

    public TransactionController(TransactionServiceContext transactionContext) {
        this.transactionContext = transactionContext;
    }

    @PostMapping(value = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionResponseModel> createTransaction(@RequestHeader("Authorization") String authorizationHeader,
                                                                      @RequestBody CreateTransactionRequestModel request) {
        TransactionDTO transactionDTO = MapperUtils.map(request, TransactionDTO.class);
        TransactionResponseModel response = MapperUtils.map(transactionContext.processTransaction(authorizationHeader,
                transactionDTO, TransactionType.DEPOSIT), TransactionResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
