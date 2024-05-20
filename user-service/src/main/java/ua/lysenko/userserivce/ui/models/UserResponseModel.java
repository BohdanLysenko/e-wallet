package ua.lysenko.userserivce.ui.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseModel {
    private String firstName;
    private String lastName;
    private String email;
    private String walletNumber;
}
