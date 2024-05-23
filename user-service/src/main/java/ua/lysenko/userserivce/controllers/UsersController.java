package ua.lysenko.userserivce.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.lysenko.userserivce.service.UserService;
import ua.lysenko.userserivce.shared.MapperUtils;
import ua.lysenko.userserivce.ui.models.UserResponseModel;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {


    private final UserService userService;

    public UsersController(Environment environment, UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Get user details by User ID")
    public ResponseEntity<UserResponseModel> getUserById(@PathVariable Long id,
                                                         @RequestHeader("Authorization") String token) {
        UserResponseModel retVal = MapperUtils.map(userService.getUserDetailsById(id, token), UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @PatchMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Update user role to admin (Admin only) by User email")
    public ResponseEntity<UserResponseModel> updateUserRole(@RequestParam String email) {
        UserResponseModel retVal = MapperUtils.map(userService.updateUserAdminRole(email), UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @PostMapping("/unblock/{userId}")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Unblock user by user ID")
    public ResponseEntity<Void> getAllUsers(@PathVariable Long userId) {
        userService.unblockUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Get list of all users (for admin users only)")
    public ResponseEntity<List<UserResponseModel>> getAllUsers(@RequestParam(defaultValue = "0")
                                                               Integer pageNumber,
                                                               @RequestParam(defaultValue = "50")
                                                               Integer pageSize) {
        List<UserResponseModel> users = userService.getAllUsers(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(user -> MapperUtils.map(user, UserResponseModel.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}