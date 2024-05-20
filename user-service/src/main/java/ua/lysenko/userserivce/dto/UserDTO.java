package ua.lysenko.userserivce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Long id;

    private String walletNumber;

}