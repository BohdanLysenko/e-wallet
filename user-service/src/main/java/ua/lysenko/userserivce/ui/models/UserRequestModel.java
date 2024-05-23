package ua.lysenko.userserivce.ui.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestModel {
    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name cannot be less than 2 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, message = "Last name cannot be less than 2 characters")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password cannot be less than 8 characters")
    @Size(max = 16, message = "Password  cannot be more than 16 characters")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
}
