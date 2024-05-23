package ua.lysenko.banking.transaction.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.TransferTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.repository.TransferTransactionRepository;
import ua.lysenko.banking.transaction.service.TransactionService;
import ua.lysenko.banking.utils.Mappers.TransferTransactionMapper;

import java.util.UUID;

@Service
@Slf4j
public class TransferTransactionService implements TransactionService {

    private final CardService cardService;
    private final TransferTransactionRepository transferTransactionRepository;
    private final TransferTransactionMapper transferTransactionMapper;

    public TransferTransactionService(CardService cardService,
                                      TransferTransactionRepository transferTransactionRepository,
                                      TransferTransactionMapper transferTransactionMapper) {
        this.cardService = cardService;
        this.transferTransactionRepository = transferTransactionRepository;
        this.transferTransactionMapper = transferTransactionMapper;
    }

    @Override
    public TransactionDTO processTransaction(TransactionDTO transactionDTO) {
        Card card = cardService.getByCardNumber(transactionDTO.getCardNumber());
        Long destinationCardId = cardService.getIdByCardNumber(transactionDTO.getDestinationCardNumber());
        TransferTransaction transferTransaction = buildTransferTransaction(transactionDTO, card, destinationCardId);
        if (!transferTransaction.isSuccessful()) {
            transferTransactionRepository.save(transferTransaction);
        } else {
            cardService.withdraw(transactionDTO.getAmount(), card.getId());
            cardService.deposit(transactionDTO.getAmount(), destinationCardId);
            transferTransaction.setSuccessful(true);
            transferTransaction = transferTransactionRepository.save(transferTransaction);
        }
        transactionDTO = transferTransactionMapper.toTransactionDTO(transferTransaction);
        transactionDTO.setCardNumber(card.getCardNumber());
        transactionDTO.setDestinationCardNumber(transactionDTO.getDestinationCardNumber());
        transactionDTO.setBalance(card.getBalance());
        transactionDTO.setTransactionType(TransactionType.TRANSFER);
        return transactionDTO;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.TRANSFER;
    }

    private static TransferTransaction buildTransferTransaction(TransactionDTO transactionDTO,
                                                                Card card,
                                                                Long destinationCardId) {
        return TransferTransaction.builder()
                .transactionUUID(UUID.randomUUID())
                .amount(transactionDTO.getAmount())
                .cardId(card.getId())
                .destinationCardId(destinationCardId)
                .isSuspicious(transactionDTO.isSuspicious())
                .isSuccessful(transactionDTO.isSuccessful())
                .build();
    }
}
