package ua.lysenko.banking.transaction.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.service.TransactionService;
import ua.lysenko.banking.transaction.enums.TransactionType;

@Service
@Slf4j
public class WithdrawalTransactionService implements TransactionService {
    @Override
    public TransactionDTO processTransaction(TransactionDTO transaction) {
        return new TransactionDTO();
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.WITHDRAWAL;
    }
}
