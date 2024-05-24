package ua.lysenko.banking.wallet.controller;

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
import ua.lysenko.banking.utils.mappers.WalletMapper;
import ua.lysenko.banking.wallet.dto.WalletDTO;
import ua.lysenko.banking.wallet.models.WalletResponseModel;
import ua.lysenko.banking.wallet.service.WalletService;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WalletController.class)
@ExtendWith({SpringExtension.class})
public class WalletControllerTest {

    public static final String VALID_TOKEN = "easdfsa1231sa";
    public static final String FIRST_NAME = "fristName";
    public static final String LAST_NAME = "lastName";
    public static final long ID = 1L;
    public static final String WALLET_NUMBER = "12312312";

    @MockBean
    private WalletService walletService;

    @MockBean
    private WalletMapper walletMapper;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;


    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    @DisplayName("Should get wallet with all attached cards by authorization header")
    void getWallet() throws Exception {
        WalletDTO walletDTO = buildWalletDTO();
        WalletResponseModel walletResponseModel = buildWalletResponseModel(walletDTO);
        when(walletService.getWallet(VALID_TOKEN)).thenReturn(walletDTO);
        when(walletMapper.toWalletResponseModel(walletDTO)).thenReturn(walletResponseModel);


        mockMvc.perform(get("/wallet")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.walletNumber").value(walletDTO.getWalletNumber()))
                .andExpect(jsonPath("$.walletHolderName").value(walletDTO.getWalletHolderName()))
                .andExpect(jsonPath("$.walletHolderLastName").value(walletDTO.getWalletHolderName()))
                .andExpect(jsonPath("$.active").value(true))
                .andExpect(jsonPath("$.cards").isArray());
    }
    @Test
    @DisplayName("Should delete wallet by authorization header")
    void deactivateWallet() throws Exception {

        mockMvc.perform(delete("/wallet/delete")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    private static WalletResponseModel buildWalletResponseModel(WalletDTO walletDTO) {
        return WalletResponseModel.builder()
                .walletHolderName(walletDTO.getWalletHolderName())
                .active(true)
                .walletHolderLastName(walletDTO.getWalletHolderName())
                .walletNumber(walletDTO.getWalletNumber())
                .cards(new ArrayList<>())
                .build();
    }

    private static WalletDTO buildWalletDTO() {
        return WalletDTO.builder()
                .walletNumber(WALLET_NUMBER)
                .id(ID)
                .walletHolderName(FIRST_NAME)
                .walletHolderLastName(LAST_NAME)
                .cards(new ArrayList<>())
                .active(true)
                .build();
    }
}