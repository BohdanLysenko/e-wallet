package ua.lysenko.banking.transaction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.models.CreatePaymentTransactionRequestModel;
import ua.lysenko.banking.transaction.models.CreateTransactionRequestModel;
import ua.lysenko.banking.transaction.models.CreateTransferTransactionRequestModel;
import ua.lysenko.banking.transaction.models.TransactionResponseModel;
import ua.lysenko.banking.transaction.service.TransactionServiceContext;
import ua.lysenko.banking.transaction.service.implementation.TransactionServiceImpl;
import ua.lysenko.banking.utils.mappers.TransactionContextMapper;
import ua.lysenko.banking.utils.mappers.TransactionControllerMapper;
import ua.lysenko.banking.utils.mappers.TransactionsResponseModelMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
@ExtendWith({SpringExtension.class})
public class TransactionControllerTest {

    public static final String VALID_TOKEN = "easdfsa1231sa";
    public static final String CARD_NUMBER = "123131";
    public static final String TRANSACTION_UUID = "077285d9-c88c-406a-92d3-114fe0ed59b0";
    public static final String DESTINATION_CARD_NUMBER = "1231231";
    public static final Long MERCHANT_ID = 123123123L;

    @MockBean
    private TransactionServiceContext transactionContext;

    @MockBean
    private TransactionContextMapper transactionContextMapper;
    @MockBean
    private TransactionsResponseModelMapper transactionMapper;
    @MockBean
    private TransactionControllerMapper transactionControllerMapper;
    @MockBean
    private TransactionServiceImpl transactionService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;


    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    @DisplayName("Should deposit successfully")
    void depositTransaction() throws Exception {
        CreateTransactionRequestModel requestModel = buildTransactionRequestModel();
        TransactionResponseModel responseModel = buildTransactionResponseModel(requestModel, "DEPOSIT");
        TransactionDTO transactionDTO = buildTransactionDTO(requestModel, TransactionType.DEPOSIT);


        when(transactionControllerMapper.toTransactionDTO(requestModel)).thenReturn(transactionDTO);
        when(transactionContextMapper.toTransactionResponseModel(any(), any())).thenReturn(responseModel);
        when(transactionContext.processTransaction(VALID_TOKEN, transactionDTO, TransactionType.DEPOSIT))
                .thenReturn(transactionDTO);


        mockMvc.perform(post("/transactions/deposit")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestModel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionUUID").value(TRANSACTION_UUID))
                .andExpect(jsonPath("$.amount").value(requestModel.getAmount()))
                .andExpect(jsonPath("$.successful").value(true))
                .andExpect(jsonPath("$.cardNumber").value(requestModel.getCardNumber()))
                .andExpect(jsonPath("$.transactionType").value(TransactionType.DEPOSIT.toString()));
    }

    @Test
    @DisplayName("Should withdraw successfully")
    void withdrawTransaction() throws Exception {
        CreateTransactionRequestModel requestModel = buildTransactionRequestModel();
        TransactionResponseModel responseModel = buildTransactionResponseModel(requestModel, "WITHDRAWAL");
        TransactionDTO transactionDTO = buildTransactionDTO(requestModel, TransactionType.WITHDRAWAL);


        when(transactionControllerMapper.toTransactionDTO(requestModel)).thenReturn(transactionDTO);
        when(transactionContextMapper.toTransactionResponseModel(any(), any())).thenReturn(responseModel);
        when(transactionContext.processTransaction(VALID_TOKEN, transactionDTO, TransactionType.WITHDRAWAL))
                .thenReturn(transactionDTO);


        mockMvc.perform(post("/transactions/withdraw")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestModel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionUUID").value(TRANSACTION_UUID))
                .andExpect(jsonPath("$.amount").value(requestModel.getAmount()))
                .andExpect(jsonPath("$.successful").value(true))
                .andExpect(jsonPath("$.cardNumber").value(requestModel.getCardNumber()))
                .andExpect(jsonPath("$.transactionType").value(TransactionType.WITHDRAWAL.toString()));
    }

    @Test
    @DisplayName("Should transfer successfully")
    void transferTransaction() throws Exception {
        CreateTransferTransactionRequestModel requestModel = buildTransferTransactionRequestModel();
        TransactionResponseModel responseModel = buildTransferTransactionResponseModel(requestModel, "TRANSFER");
        TransactionDTO transactionDTO = buildTransferTransactionDTO(requestModel, TransactionType.TRANSFER);


        when(transactionControllerMapper.toTransactionDTO(requestModel)).thenReturn(transactionDTO);
        when(transactionContextMapper.toTransactionResponseModel(any(), any())).thenReturn(responseModel);
        when(transactionContext.processTransaction(VALID_TOKEN, transactionDTO, TransactionType.TRANSFER))
                .thenReturn(transactionDTO);


        mockMvc.perform(post("/transactions/transfer")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestModel)))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$.transactionUUID").value(TRANSACTION_UUID))
                .andExpect(jsonPath("$.amount").value(requestModel.getAmount()))
                .andExpect(jsonPath("$.successful").value(true))
                .andExpect(jsonPath("$.cardNumber").value(requestModel.getCardNumber()))
                .andExpect(jsonPath("$.destinationCardNumber").value(requestModel.getDestinationCardNumber()))
                .andExpect(jsonPath("$.transactionType").value(TransactionType.TRANSFER.toString()));
    }

    @Test
    @DisplayName("Should send payment successfully")
    void paymentTransaction() throws Exception {
        CreatePaymentTransactionRequestModel requestModel = buildPaymentTransactionRequestModel();
        TransactionResponseModel responseModel = buildPaymentTransactionResponseModel(requestModel, "PAYMENT");
        TransactionDTO transactionDTO = buildPaymentTransactionDTO(requestModel, TransactionType.PAYMENT);


        when(transactionControllerMapper.toTransactionDTO(requestModel)).thenReturn(transactionDTO);
        when(transactionContextMapper.toTransactionResponseModel(any(), any())).thenReturn(responseModel);
        when(transactionContext.processTransaction(VALID_TOKEN, transactionDTO, TransactionType.PAYMENT))
                .thenReturn(transactionDTO);


        mockMvc.perform(post("/transactions/payment")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestModel)))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$.transactionUUID").value(TRANSACTION_UUID))
                .andExpect(jsonPath("$.amount").value(requestModel.getAmount()))
                .andExpect(jsonPath("$.successful").value(true))
                .andExpect(jsonPath("$.cardNumber").value(requestModel.getCardNumber()))
                .andExpect(jsonPath("$.merchantId").value(requestModel.getMerchantId()))
                .andExpect(jsonPath("$.transactionType").value(TransactionType.PAYMENT.toString()));
    }

    @Test
    @DisplayName("Should list all transactions by card number")
    void getAllTransactionsByCard() throws Exception {
        CreatePaymentTransactionRequestModel requestModel = buildPaymentTransactionRequestModel();
        CreateTransferTransactionRequestModel requestModel1 = buildTransferTransactionRequestModel();
        TransactionResponseModel responseModel = buildTransactionResponseModel(requestModel, "DEPOSIT");
        TransactionResponseModel responseModel1 = buildTransactionResponseModel(requestModel1, "TRANSFER");
        TransactionDTO transactionDTO = buildTransactionDTO(requestModel, TransactionType.DEPOSIT);
        TransactionDTO transactionDTO1 = buildTransferTransactionDTO(requestModel1, TransactionType.TRANSFER);
        List<TransactionDTO> transactionsDTO = new ArrayList<>(List.of(transactionDTO, transactionDTO1));
        List<TransactionResponseModel> transactionResponseModels = new ArrayList<>(List.of(
                responseModel, responseModel1));

        PageRequest pageRequest = PageRequest.of(0, 20);
        when(transactionService.getAllTransactionsByCardId(VALID_TOKEN, requestModel.getCardNumber(),
                pageRequest)).thenReturn(transactionsDTO);
        when(transactionMapper.toTransactionsResponseModel(any()))
                .thenReturn(transactionResponseModels);


        mockMvc.perform(get("/transactions/all")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .param("pageNumber", "0")
                        .param("pageSize", "20")
                        .param("cardNumber", CARD_NUMBER)
                        .content(asJsonString(requestModel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(transactionResponseModels.size()));
    }

    private static CreateTransactionRequestModel buildTransactionRequestModel() {
        return CreateTransactionRequestModel.builder()
                .amount(BigDecimal.TEN)
                .cardNumber(CARD_NUMBER)
                .build();
    }

    private static CreateTransferTransactionRequestModel buildTransferTransactionRequestModel() {
        return CreateTransferTransactionRequestModel.builder()
                .amount(BigDecimal.TEN)
                .cardNumber(CARD_NUMBER)
                .destinationCardNumber(DESTINATION_CARD_NUMBER)
                .build();
    }

    private static CreatePaymentTransactionRequestModel buildPaymentTransactionRequestModel() {
        return CreatePaymentTransactionRequestModel.builder()
                .amount(BigDecimal.TEN)
                .cardNumber(CARD_NUMBER)
                .merchantId(MERCHANT_ID)
                .build();
    }

    private static TransactionResponseModel buildTransactionResponseModel(CreateTransactionRequestModel requestModel,
                                                                          String transactionType) {
        return TransactionResponseModel.builder()
                .transactionUUID(TRANSACTION_UUID)
                .amount(requestModel.getAmount())
                .isSuccessful(true)
                .transactionType(transactionType)
                .cardNumber(requestModel.getCardNumber())
                .build();
    }

    private static TransactionResponseModel buildTransferTransactionResponseModel(CreateTransactionRequestModel requestModel,
                                                                                  String transactionType) {
        return TransactionResponseModel.builder()
                .transactionUUID(TRANSACTION_UUID)
                .amount(requestModel.getAmount())
                .isSuccessful(true)
                .destinationCardNumber(DESTINATION_CARD_NUMBER)
                .transactionType(transactionType)
                .cardNumber(requestModel.getCardNumber())
                .build();
    }

    private static TransactionResponseModel buildPaymentTransactionResponseModel(CreateTransactionRequestModel requestModel,
                                                                                 String transactionType) {
        return TransactionResponseModel.builder()
                .transactionUUID(TRANSACTION_UUID)
                .amount(requestModel.getAmount())
                .isSuccessful(true)
                .merchantId(MERCHANT_ID)
                .transactionType(transactionType)
                .cardNumber(requestModel.getCardNumber())
                .build();
    }


    private static TransactionDTO buildTransactionDTO(CreateTransactionRequestModel requestModel, TransactionType transactionType) {
        return TransactionDTO.builder()
                .transactionUUID(TRANSACTION_UUID)
                .amount(requestModel.getAmount())
                .isSuccessful(true)
                .transactionType(transactionType)
                .cardNumber(requestModel.getCardNumber())
                .build();
    }

    private static TransactionDTO buildTransferTransactionDTO(CreateTransactionRequestModel requestModel, TransactionType transactionType) {
        return TransactionDTO.builder()
                .transactionUUID(TRANSACTION_UUID)
                .amount(requestModel.getAmount())
                .isSuccessful(true)
                .transactionType(transactionType)
                .cardNumber(requestModel.getCardNumber())
                .destinationCardNumber(DESTINATION_CARD_NUMBER)
                .build();
    }

    private static TransactionDTO buildPaymentTransactionDTO(CreateTransactionRequestModel requestModel, TransactionType transactionType) {
        return TransactionDTO.builder()
                .transactionUUID(TRANSACTION_UUID)
                .amount(requestModel.getAmount())
                .isSuccessful(true)
                .transactionType(transactionType)
                .cardNumber(requestModel.getCardNumber())
                .merchantId(MERCHANT_ID)
                .build();
    }

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
