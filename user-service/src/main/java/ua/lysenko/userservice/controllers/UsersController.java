package ua.lysenko.userservice.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.lysenko.userservice.service.UserService;
import ua.lysenko.userservice.ui.models.UserResponseModel;
import ua.lysenko.userservice.utils.mappers.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {


    private final UserService userService;
    private final UserMapper userMapper;

    public UsersController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Get user details by User ID")
    public ResponseEntity<UserResponseModel> getUserById(@RequestHeader("Authorization") String token) {
        UserResponseModel retVal = userMapper.toUserResponseModel(userService.getUserDetails(token));
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @PatchMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Update user role to admin (Admin only) by User email")
    public ResponseEntity<UserResponseModel> updateUserRole(@RequestParam String email) {
        UserResponseModel retVal = userMapper.toUserResponseModel(userService.updateUserAdminRole(email));
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @PostMapping("/unblock/{userId}")
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Unblock user by user ID")
    public ResponseEntity<Void> unblockUserById(@PathVariable Long userId) {
        userService.unblockUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Get list of all users (for admin users only)")
    public ResponseEntity<List<UserResponseModel>> getAllUsers(@RequestParam(defaultValue = "0")
                                                               Integer pageNumber,
                                                               @RequestParam(defaultValue = "50")
                                                               Integer pageSize) {
        List<UserResponseModel> users = userService.getAllUsers(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(user -> userMapper.toUserResponseModel(user))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}