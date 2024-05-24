package ua.lysenko.userservice.controllers;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.lysenko.userservice.dto.UserDTO;
import ua.lysenko.userservice.entity.Role;
import ua.lysenko.userservice.security.AuthenticationFilter;
import ua.lysenko.userservice.service.JwtService;
import ua.lysenko.userservice.service.UserService;
import ua.lysenko.userservice.ui.models.UserResponseModel;
import ua.lysenko.userservice.utils.mappers.UserMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersController.class)
@ExtendWith({SpringExtension.class})
class UsersControllerTest {

    public static final String VALID_TOKEN = "easdfsa1231sa";
    public static final String USER_EMAIL = "testuser@example.com";
    public static final String FIRST_NAME = "testuser";
    public static final long ID = 1L;
    public static final String WALLET_NUMBER = "12312312";
    public static final String USER = "User";
    public static final String ADMIN = "Admin";
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    JwtService jwtService;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(new AuthenticationFilter(jwtService, userService), "/*")
                .build();
        when(jwtService.extractUserName(VALID_TOKEN)).thenReturn(USER_EMAIL);
    }


    @Test
    @DisplayName("Get user details by provided token")
    void signUp() throws Exception {
        UserResponseModel userResponseModel = buildUserResponseModel();
        UserDTO userDTO = buildUserDTO();

        when(userService.getUserDetails(anyString())).thenReturn(userDTO);
        when(userMapper.toUserResponseModel(userDTO)).thenReturn(userResponseModel);

        mockMvc.perform(get("/users")
                        .header(HttpHeaders.AUTHORIZATION, VALID_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ID))
                .andExpect(jsonPath("$.firstName").value(FIRST_NAME))
                .andExpect(jsonPath("$.email").value(USER_EMAIL))
                .andExpect(jsonPath("$.walletNumber").value(WALLET_NUMBER))
                .andExpect(jsonPath("$.role").value(USER));
    }

    @Test
    @DisplayName("Update User Role to Admin")
    @WithMockUser(roles = "ADMIN")
    void updateUserRole() throws Exception {
        UserResponseModel userResponseModel = buildAdminResponseModel();
        UserDTO userDTO = buildUserAdminDTO();

        when(userService.updateUserAdminRole(USER_EMAIL)).thenReturn(userDTO);
        when(userMapper.toUserResponseModel(userDTO)).thenReturn(userResponseModel);

        mockMvc.perform(patch("/users/admin")
                        .param("email", USER_EMAIL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ID))
                .andExpect(jsonPath("$.firstName").value(FIRST_NAME))
                .andExpect(jsonPath("$.email").value(USER_EMAIL))
                .andExpect(jsonPath("$.walletNumber").value(WALLET_NUMBER))
                .andExpect(jsonPath("$.role").value(ADMIN));
    }

    @Test
    @DisplayName("Unblock user by ID")
    @WithMockUser(roles = "ADMIN")
    void unblockUserById() throws Exception {
        mockMvc.perform(post("/users/unblock/{userId}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get list of all users")
    @WithMockUser(roles = "ADMIN")
    void getAllUsers() throws Exception {
        UserResponseModel userResponseModel = buildAdminResponseModel();
        UserDTO userDTO = buildUserDTO();

        List<UserResponseModel> usersResponseModel = new ArrayList<>(List.of(userResponseModel, userResponseModel));
        List<UserDTO> usersDTO = new ArrayList<>(List.of(userDTO, userDTO));

        when(userService.getAllUsers(PageRequest.of(0, 50))).thenReturn(usersDTO);
        when(userMapper.toUserResponseModel(any())).thenReturn(userResponseModel);

        mockMvc.perform(get("/users/all")
                        .param("pageNumber", "0")
                        .param("pageSize", "50")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(usersResponseModel.size()));
    }

    private static UserResponseModel buildUserResponseModel() {
        return UserResponseModel.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .email(USER_EMAIL)
                .walletNumber(WALLET_NUMBER)
                .role(USER)
                .build();
    }

    private static UserResponseModel buildAdminResponseModel() {
        return UserResponseModel.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .email(USER_EMAIL)
                .walletNumber(WALLET_NUMBER)
                .role(ADMIN)
                .build();
    }

    private static UserDTO buildUserDTO() {
        return UserDTO.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .email(USER_EMAIL)
                .walletNumber(WALLET_NUMBER)
                .role(Role.ROLE_USER)
                .build();
    }

    private static UserDTO buildUserAdminDTO() {
        return UserDTO.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .email(USER_EMAIL)
                .walletNumber(WALLET_NUMBER)
                .role(Role.ROLE_ADMIN)
                .build();
    }
}