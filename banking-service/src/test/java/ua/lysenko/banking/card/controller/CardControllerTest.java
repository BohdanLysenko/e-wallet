package ua.lysenko.banking.card.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CardResponseModel;
import ua.lysenko.banking.card.service.CardService;
import ua.lysenko.banking.utils.mappers.CardMapper;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardController.class)
@ExtendWith({SpringExtension.class})
public class CardControllerTest {

    public static final String VALID_TOKEN = "easdfsa1231sa";
    public static final Long CARD_ID = 10L;
    public static final String CARD_NUMBER = "1231231231";
    public static final String WALLET_NUMBER = "1231231";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    @MockBean
    private CardService cardService;
    @MockBean
    private CardMapper cardMapper;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;


    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    @DisplayName("Should create a new card for user by authorization header")
    void createCard() throws Exception {
        CardDTO cardDTO = buildCardDTO();
        CardResponseModel cardResponseModel = buildCardResponseModel();

        when(cardService.createCard(VALID_TOKEN)).thenReturn(cardDTO);
        when(cardMapper.toCardResponseModel(cardDTO)).thenReturn(cardResponseModel);

        mockMvc.perform(post("/cards/create")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cardResponseModel.getId()))
                .andExpect(jsonPath("$.cardNumber").value(cardResponseModel.getCardNumber()))
                .andExpect(jsonPath("$.active").value(true))
                .andExpect(jsonPath("$.walletNumber").value(cardResponseModel.getWalletNumber()))
                .andExpect(jsonPath("$.balance").value(cardResponseModel.getBalance()))
                .andExpect(jsonPath("$.cardHolderName").value(cardResponseModel.getCardHolderName()))
                .andExpect(jsonPath("$.cardHolderLastName").value(cardResponseModel.getCardHolderLastName()));
    }

    @Test
    @DisplayName("Should get a card by id and authorization header")
    void getCardById() throws Exception {
        CardDTO cardDTO = buildCardDTO();
        CardResponseModel cardResponseModel = buildCardResponseModel();

        when(cardService.getById(cardDTO.getId(), VALID_TOKEN)).thenReturn(cardDTO);
        when(cardMapper.toCardResponseModel(cardDTO)).thenReturn(cardResponseModel);

        mockMvc.perform(get("/cards/{userId}", "10")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cardResponseModel.getId()))
                .andExpect(jsonPath("$.cardNumber").value(cardResponseModel.getCardNumber()))
                .andExpect(jsonPath("$.active").value(true))
                .andExpect(jsonPath("$.walletNumber").value(cardResponseModel.getWalletNumber()))
                .andExpect(jsonPath("$.balance").value(cardResponseModel.getBalance()))
                .andExpect(jsonPath("$.cardHolderName").value(cardResponseModel.getCardHolderName()))
                .andExpect(jsonPath("$.cardHolderLastName").value(cardResponseModel.getCardHolderLastName()));
    }

    private static CardResponseModel buildCardResponseModel() {
        return CardResponseModel.builder()
                .cardNumber(CARD_NUMBER)
                .id(CARD_ID)
                .active(true)
                .walletNumber(WALLET_NUMBER)
                .balance(BigDecimal.ZERO)
                .cardHolderName(FIRST_NAME)
                .cardHolderLastName(LAST_NAME)
                .build();
    }

    private static CardDTO buildCardDTO() {
        return CardDTO.builder()
                .id(CARD_ID)
                .cardNumber(CARD_NUMBER)
                .balance(BigDecimal.valueOf(10000))
                .build();
    }
}