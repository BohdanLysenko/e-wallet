package ua.lysenko.userservice.dto;

import lombok.*;
import ua.lysenko.userservice.entity.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String walletNumber;
    private Long isWalletActive;
    private Role role;

}