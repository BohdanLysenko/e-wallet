package ua.lysenko.userservice.ui.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String walletNumber;
    String role;
}
