package ua.lysenko.banking.transaction.service;

import ua.lysenko.banking.entity.Transaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;

public interface TransactionService {
    TransactionDTO processTransaction(TransactionDTO transaction);

    TransactionType getTransactionType();
}
