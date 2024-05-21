package ua.lysenko.banking.transaction.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.DepositTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.repository.DepositTransactionRepository;
import ua.lysenko.banking.transaction.service.TransactionService;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.utils.MapperUtils;

import java.util.UUID;

@Service
@Slf4j
@Transactional
public class DepositTransactionService implements TransactionService {

    private final CardService cardService;

    private final DepositTransactionRepository depositTransactionRepository;

    public DepositTransactionService(CardService cardService, DepositTransactionRepository depositTransactionRepository) {
        this.cardService = cardService;
        this.depositTransactionRepository = depositTransactionRepository;
    }

    @Override
    public TransactionDTO processTransaction(TransactionDTO transactionDTO) {
        Card card = cardService.getByCardNumber(transactionDTO.getCardNumber());

        DepositTransaction depositTransaction = DepositTransaction.builder()
                .transactionUUID(UUID.randomUUID())
                .amount(transactionDTO.getAmount())
                .cardId(card.getId())
                .isSuspicious(false)
                .isSuccessful(true)
                .build();

        boolean isDepositPerformed = cardService.deposit(transactionDTO.getAmount(), card.getId());

        depositTransaction.setSuccessful(isDepositPerformed);
        depositTransaction = depositTransactionRepository.save(depositTransaction);

        transactionDTO = MapperUtils.map(depositTransaction, TransactionDTO.class);
        transactionDTO.setCardNumber(card.getCardNumber());
        transactionDTO.setTransactionType(TransactionType.DEPOSIT);
        return transactionDTO;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.DEPOSIT;
    }
}
