package ua.lysenko.userserivce.ui.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseModel {
    private String firstName;
    private String lastName;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String walletNumber;
}
