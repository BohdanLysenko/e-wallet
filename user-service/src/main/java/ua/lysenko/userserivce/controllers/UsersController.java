package ua.lysenko.userserivce.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import ua.lysenko.userserivce.service.UserService;
import ua.lysenko.userserivce.shared.MapperUtils;
import ua.lysenko.userserivce.shared.Utils;
import ua.lysenko.userserivce.ui.models.UserResponseModel;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    Environment environment;

    @Autowired
    UserService userService;

    @Autowired
    Utils utils;


    @GetMapping("/status/check")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Get server status")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Server Is UP", content = @Content), @ApiResponse(responseCode = "404", description = "Server Is Down", content = @Content)})
    public String status() {
        environment.getProperty("eureka.instance.instance-id");
        return "Working on port: " + environment.getProperty("local.server.port") + "\ntoken:" + environment.getProperty("token.secret");
    }

    @GetMapping("{id}")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Get user details by id")
    public ResponseEntity<UserResponseModel> getUserById(@PathVariable Long id,
                                                         @RequestHeader("Authorization") String token) {
        UserResponseModel retVal = MapperUtils.map(userService.getUserDetailsById(id,token), UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @PatchMapping("/admin/update/{email}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Update user role to admin (Admin only)")
    public ResponseEntity<UserResponseModel> updateUserRole(@PathVariable String email) {
        UserResponseModel retVal = MapperUtils.map(userService.updateUserAdminRole(email), UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }
}