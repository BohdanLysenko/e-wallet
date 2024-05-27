package ua.lysenko.banking.transaction.service.implementation;

import common.grpc.users.UserMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Transaction;
import ua.lysenko.banking.exception.UnauthorizedAccessException;
import ua.lysenko.banking.service.CommonBankingServiceGrpc;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.repository.TransactionRepository;
import ua.lysenko.banking.utils.mappers.TransactionMapper;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.wallet.service.WalletService;

import java.util.List;

@Service
public class TransactionServiceImpl {

    private final TransactionRepository transactionRepository;


    private final WalletService walletService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;
    private final CommonBankingServiceGrpc commonBankingServiceGrpc;


    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  WalletService walletService,
                                  CardService cardService,
                                  TransactionMapper transactionMapper,
                                  CommonBankingServiceGrpc commonBankingServiceGrpc) {
        this.transactionRepository = transactionRepository;
        this.walletService = walletService;
        this.cardService = cardService;
        this.transactionMapper = transactionMapper;
        this.commonBankingServiceGrpc = commonBankingServiceGrpc;
    }

    public List<TransactionDTO> getAllTransactionsByCardId(String token, String cardNumber,
                                                           Pageable pageable) {
        UserMessage userMessage = commonBankingServiceGrpc.getCurrentUser(token);
        Long userId = userMessage.getId();
        Long walletId = walletService.getWalletByUserId(userId).getId();
        CardDTO card = cardService.getByCardNumber(cardNumber);
        if (card.getWalletId() == walletId) {
            Page<Transaction> transactions = transactionRepository.findAllByCardIdOrderByCreatedDateDesc(card.getId(),
                    pageable);
            return transactions.stream()
                    .map(transaction -> {
                        TransactionDTO transactionDTO = transactionMapper.toTransactionDTO(transaction);
                        transactionDTO = transactionMapper.updateTransactionDTO(transaction, transactionDTO);
                        transactionDTO.setTransactionType(transaction.type());
                        return transactionDTO;
                    })
                    .toList();
        } else {
            throw new UnauthorizedAccessException(ExceptionKeys.UNAUTHORIZED_ACCESS.getMessage());
        }
    }
}