package ua.lysenko.banking.card.service;

import common.grpc.Users.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CreateCardResponseModel;
import ua.lysenko.banking.card.repository.CardRepository;
import ua.lysenko.banking.exception.CardNotFoundException;
import ua.lysenko.banking.utils.textresources.ExceptionKeys;
import ua.lysenko.banking.utils.validators.UserDetailsResponseValidator;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.exception.AccountIsLockedException;
import ua.lysenko.banking.utils.MapperUtils;
import ua.lysenko.banking.wallet.service.WalletService;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;
    private final CardRepository cardRepository;

    // Todo @Qualifier
    private final UserDetailsResponseValidator userDetailsResponseValidator;

    private final WalletService walletService;

    public CardServiceImpl(UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub,
                           CardRepository cardRepository,
                           UserDetailsResponseValidator userDetailsResponseValidator,
                           WalletService walletService) {
        this.userServiceBlockingStub = userServiceBlockingStub;
        this.cardRepository = cardRepository;
        this.userDetailsResponseValidator = userDetailsResponseValidator;
        this.walletService = walletService;
    }


    public CreateCardResponseModel createCard(String token) {
        UserMessage user = getCurrentUser(token);
        if (!userDetailsResponseValidator.isValid(user)) {
            throw new AccountIsLockedException(ExceptionKeys.ACCOUNT_IS_LOCKED.getMessage());
        }
        CardDTO cardDTO = createCardByUserId(user.getId());
        CreateCardResponseModel createdCard = MapperUtils.map(cardDTO, CreateCardResponseModel.class);
        createdCard.setCardHolderName(user.getFirstName());
        createdCard.setCardHolderLastName(user.getLastName());
        return createdCard;
    }

    @Override
    public CardDTO createCardByUserId(Long userID) {
        Wallet wallet = walletService.getWalletByUserId(userID);
        Card card = Card.builder()
                .balance(BigDecimal.ZERO)
                .cvv(100 + (int) (Math.random() * ((999 - 100) + 1)))
                .expirationDate(calculateExpirationDate())
                .cardNumber(generateCardNumber())
                .active(true)
                .wallet(wallet)
                .build();
        CardDTO cardDTO = MapperUtils.map(cardRepository.save(card), CardDTO.class);
        cardDTO.setWalletNumber(wallet.getWalletNumber().toString());
        return cardDTO;
    }

    @Override
    public Card getByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumberAndActiveIsTrue(cardNumber).orElseThrow(
                () -> new CardNotFoundException(
                        String.format(ExceptionKeys.CARD_NUMBER_NOT_FOUND.getMessage(), cardNumber)));
    }

    @Override
    public Card getById(Long id) {
        return cardRepository.findByIdAndActiveIsTrue(id).orElseThrow(
                () -> new CardNotFoundException(
                        String.format(ExceptionKeys.CARD_ID_NOT_FOUND.getMessage())));
    }

    // ToDo try catch exception?
    @Override
    public boolean deposit(BigDecimal amount, Long cardId) {
        Card card = getById(cardId);
        card.setBalance(card.getBalance().add(amount));
        cardRepository.save(card);
        return true;
    }

    private long getCurrentUserId(String token) {
        UserMessage userDetailsResponse = getCurrentUser(token);
        return userDetailsResponse.getId();
    }

    private UserMessage getCurrentUser(String token) {
        UserTokenRequest userTokenRequest = UserTokenRequest.newBuilder()
                .setToken(token)
                .build();
        return userServiceBlockingStub.getUserDetails(userTokenRequest).getResp();
    }


    // ToDo
    private static Date calculateExpirationDate() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, 3);
        return calendar.getTime();
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
