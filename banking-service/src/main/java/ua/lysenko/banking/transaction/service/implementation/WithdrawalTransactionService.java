package ua.lysenko.banking.transaction.service.implementation;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.WithdrawalTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.repository.WithdrawalTransactionRepository;
import ua.lysenko.banking.transaction.service.TransactionService;
import ua.lysenko.banking.utils.mappers.WithdrawalTransactionMapper;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class WithdrawalTransactionService implements TransactionService {
    private final CardService cardService;
    private final WithdrawalTransactionRepository withdrawalTransactionRepository;

    private final BigDecimal dailyWithdrawalLimit;

    private final WithdrawalTransactionMapper withdrawalTransactionMapper;

    public WithdrawalTransactionService(CardService cardService,
                                        WithdrawalTransactionRepository withdrawalTransactionRepository,
                                        @Value("${withdrawal.limit.daily}") BigDecimal dailyWithdrawalLimit, WithdrawalTransactionMapper withdrawalTransactionMapper) {
        this.cardService = cardService;
        this.withdrawalTransactionRepository = withdrawalTransactionRepository;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
        this.withdrawalTransactionMapper = withdrawalTransactionMapper;
    }

    @Override
    public TransactionDTO processTransaction(TransactionDTO transactionDTO) {
        Card card = cardService.findByCardNumber(transactionDTO.getCardNumber());
        WithdrawalTransaction withdrawalTransaction = buildWithdrawalTransaction(transactionDTO, card);
        if (!withdrawalTransaction.isSuccessful()) {
            withdrawalTransactionRepository.save(withdrawalTransaction);
        } else {
            boolean isWithdrawalPerformed = cardService.withdraw(transactionDTO.getAmount(), card.getId());

            withdrawalTransaction.setSuccessful(isWithdrawalPerformed);
            withdrawalTransaction = withdrawalTransactionRepository.save(withdrawalTransaction);
        }
        transactionDTO = withdrawalTransactionMapper.updateTransactionDTO(withdrawalTransaction,transactionDTO);

        transactionDTO.setCardNumber(card.getCardNumber());
        transactionDTO.setBalance(card.getBalance());
        transactionDTO.setTransactionType(TransactionType.WITHDRAWAL);
        return transactionDTO;
    }

    private static WithdrawalTransaction buildWithdrawalTransaction(TransactionDTO transactionDTO, Card card) {
        return WithdrawalTransaction.builder()
                .transactionUUID(UUID.randomUUID())
                .amount(transactionDTO.getAmount())
                .cardId(card.getId())
                .isSuspicious(transactionDTO.isSuspicious())
                .isSuccessful(transactionDTO.isSuccessful())
                .build();
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.WITHDRAWAL;
    }

    public boolean isWithdrawalLimitExceededByCard(Long cardId, BigDecimal transactionAmount) {
        BigDecimal dailyWithdrawalSum = withdrawalTransactionRepository
                .selectDailyWithdrawalAmountByCardId(cardId)
                .orElse(BigDecimal.ZERO);
        return dailyWithdrawalLimit.compareTo(dailyWithdrawalSum.add(transactionAmount)) < 0;

    }

}
