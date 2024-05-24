package ua.lysenko.banking.transaction.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.PaymentTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.repository.PaymentTransactionRepository;
import ua.lysenko.banking.transaction.service.TransactionService;
import ua.lysenko.banking.utils.mappers.PaymentTransactionMapper;

import java.util.UUID;

@Service
@Slf4j
public class PaymentTransactionService implements TransactionService {
    private final CardService cardService;

    private final PaymentTransactionRepository paymentTransactionRepository;
    private final PaymentTransactionMapper paymentTransactionMapper;

    public PaymentTransactionService(CardService cardService, PaymentTransactionRepository paymentTransactionRepository, PaymentTransactionMapper paymentTransactionMapper) {
        this.cardService = cardService;
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.paymentTransactionMapper = paymentTransactionMapper;
    }

    @Override
    public TransactionDTO processTransaction(TransactionDTO transactionDTO) {
        Card card = cardService.findByCardNumber(transactionDTO.getCardNumber());
        PaymentTransaction paymentTransaction = buildPaymentTransaction(transactionDTO, card,
                transactionDTO.getMerchantId());

        if (!paymentTransaction.isSuccessful()) {
            paymentTransactionRepository.save(paymentTransaction);
        } else {
            cardService.withdraw(transactionDTO.getAmount(), card.getId());
            paymentTransaction.setSuccessful(true);
            paymentTransaction = paymentTransactionRepository.save(paymentTransaction);
        }
        transactionDTO = paymentTransactionMapper.updateTransactionDTO(paymentTransaction, transactionDTO);
        transactionDTO.setTransactionType(TransactionType.PAYMENT);
        return transactionDTO;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.PAYMENT;
    }

    private static PaymentTransaction buildPaymentTransaction(TransactionDTO transactionDTO,
                                                              Card card,
                                                              Long merchantId) {
        return PaymentTransaction.builder()
                .transactionUUID(UUID.randomUUID())
                .amount(transactionDTO.getAmount())
                .cardId(card.getId())
                .merchantId(merchantId)
                .isSuspicious(transactionDTO.isSuspicious())
                .isSuccessful(transactionDTO.isSuccessful())
                .build();
    }
}