package ua.lysenko.banking.card.service;

import common.grpc.users.UserMessage;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.repository.CardRepository;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.exception.CardNotFoundException;
import ua.lysenko.banking.exception.UnauthorizedAccessException;
import ua.lysenko.banking.service.CommonBankingServiceGrpc;
import ua.lysenko.banking.utils.mappers.CardMapper;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.wallet.service.WalletService;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final WalletService walletService;

    private final CardMapper cardMapper;
    private final CommonBankingServiceGrpc commonBankingServiceService;

    public CardServiceImpl(CardRepository cardRepository,
                           WalletService walletService,
                           CardMapper cardMapper,
                           CommonBankingServiceGrpc commonBankingServiceService) {
        this.cardRepository = cardRepository;
        this.walletService = walletService;
        this.cardMapper = cardMapper;
        this.commonBankingServiceService = commonBankingServiceService;
    }


    public CardDTO createCard(String token) {
        UserMessage user = commonBankingServiceService.getCurrentUser(token);
        Wallet wallet = walletService.findActiveWalletByUserId(user.getId());
        Card card = Card.builder()
                .balance(BigDecimal.ZERO)
                .cvv(100 + (int) (Math.random() * ((999 - 100) + 1)))
                .expirationDate(calculateExpirationDate())
                .cardNumber(generateCardNumber())
                .active(true)
                .wallet(wallet)
                .build();
        CardDTO cardDTO = cardMapper.toCardDto(cardRepository.save(card));
        cardDTO.setWalletNumber(wallet.getWalletNumber().toString());
        cardDTO.setCardHolderName(user.getFirstName());
        cardDTO.setCardHolderLastName(user.getLastName());
        return cardDTO;
    }

    @Override
    public CardDTO getByCardNumber(String cardNumber) {
        Card card = findByCardNumber(cardNumber);
        CardDTO cardDTO = cardMapper.toCardDto(card);
        cardDTO.setWalletId(card.getWallet().getId());
        return cardDTO;
    }

    @Override
    public Card findByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumberAndActiveIsTrue(cardNumber).orElseThrow(
                () -> new CardNotFoundException(
                        String.format(ExceptionKeys.CARD_NUMBER_NOT_FOUND.getMessage(), cardNumber)));
    }

    @Override
    public Long getIdByCardNumber(String cardNumber) {
        return cardRepository.findIdByCardNumberAndActiveIsTrue(cardNumber).orElseThrow(
                () -> new CardNotFoundException(
                        String.format(ExceptionKeys.CARD_NUMBER_NOT_FOUND.getMessage(), cardNumber)));
    }

    @Override
    public CardDTO getById(Long id, String token) {
        Long walletId = walletService.getWalletByToken(token).getId();
        Card card = cardRepository.findByIdAndActiveIsTrue(id)
                .orElseThrow(() -> new CardNotFoundException(
                        String.format(ExceptionKeys.CARD_NOT_FOUND.getMessage())));
        if (walletId == card.getWallet().getId()) {
            cardMapper.toCardDto(card);
            return cardMapper.toCardDto(card);
        } else {
            throw new UnauthorizedAccessException(ExceptionKeys.UNAUTHORIZED_ACCESS.getMessage());
        }
    }

    @Override
    public List<CardDTO> getAllCardsByWalletId(Wallet wallet) {
        List<Card> cards = cardRepository.findAllByWalletAndActiveIsTrue(wallet.getId());
        return cardMapper.cardsToCardDTOs(cards);
    }

    @Override
    public boolean deposit(BigDecimal amount, Long cardId) {
        Card card = cardRepository.findByIdAndActiveIsTrue(cardId)
                .orElseThrow(() -> new CardNotFoundException(
                        String.format(ExceptionKeys.CARD_NOT_FOUND.getMessage())));
        card.setBalance(card.getBalance().add(amount));
        cardRepository.save(card);
        return true;
    }

    @Override
    public boolean withdraw(BigDecimal amount, Long cardId) {
        Card card = cardRepository.findByIdAndActiveIsTrue(cardId)
                .orElseThrow(() -> new CardNotFoundException(
                        String.format(ExceptionKeys.CARD_NOT_FOUND.getMessage())));
        card.setBalance(card.getBalance().subtract(amount));
        cardRepository.save(card);
        return true;

    }

    @Override
    public boolean isBalanceExceeded(BigDecimal amount, Long cardId) {
        Card card = cardRepository.findByIdAndActiveIsTrue(cardId)
                .orElseThrow(() -> new CardNotFoundException(
                        String.format(ExceptionKeys.CARD_NOT_FOUND.getMessage())));
        return amount.compareTo(card.getBalance()) > 0;
    }


    private static Date calculateExpirationDate() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, 3);
        return DateUtils.truncate(calendar.getTime(), java.util.Calendar.DAY_OF_MONTH);
    }

    public static String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            cardNumber.append(random.nextInt(10));
        }

        int checkDigit = calculateLuhnCheckDigit(cardNumber.toString());
        cardNumber.append(checkDigit);

        return cardNumber.toString();
    }

    private static int calculateLuhnCheckDigit(String number) {
        int sum = 0;
        boolean alternate = false;

        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        return (sum * 9) % 10;
    }
}
