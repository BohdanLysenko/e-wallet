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
import ua.lysenko.banking.utils.Mappers.DepositTransactionMapper;

import java.util.UUID;

@Service
@Slf4j
@Transactional
public class DepositTransactionService implements TransactionService {

    private final CardService cardService;
    private final DepositTransactionRepository depositTransactionRepository;
    private final DepositTransactionMapper depositTransactionMapper;

    public DepositTransactionService(CardService cardService, DepositTransactionRepository depositTransactionRepository, DepositTransactionMapper depositTransactionMapper) {
        this.cardService = cardService;
        this.depositTransactionRepository = depositTransactionRepository;
        this.depositTransactionMapper = depositTransactionMapper;
    }

    @Override
    public TransactionDTO processTransaction(TransactionDTO transactionDTO) {
        Card card = cardService.getByCardNumber(transactionDTO.getCardNumber());
        DepositTransaction depositTransaction = buildDepositTransaction(transactionDTO, card);
        if (!depositTransaction.isSuccessful()) {
            depositTransactionRepository.save(depositTransaction);
        } else {
            boolean isDepositPerformed = cardService.deposit(transactionDTO.getAmount(), card.getId());

            depositTransaction.setSuccessful(isDepositPerformed);
            depositTransaction = depositTransactionRepository.save(depositTransaction);
        }
        transactionDTO = depositTransactionMapper.toTransactionDTO(depositTransaction);
        transactionDTO.setCardNumber(card.getCardNumber());
        transactionDTO.setBalance(card.getBalance());
        transactionDTO.setTransactionType(TransactionType.DEPOSIT);
        return transactionDTO;
    }


    @Override
    public TransactionType getTransactionType() {
        return TransactionType.DEPOSIT;
    }

    private static DepositTransaction buildDepositTransaction(TransactionDTO transactionDTO, Card card) {
        return DepositTransaction.builder()
                .transactionUUID(UUID.randomUUID())
                .amount(transactionDTO.getAmount())
                .cardId(card.getId())
                .isSuspicious(transactionDTO.isSuspicious())
                .isSuccessful(transactionDTO.isSuccessful())
                .build();
    }
}
