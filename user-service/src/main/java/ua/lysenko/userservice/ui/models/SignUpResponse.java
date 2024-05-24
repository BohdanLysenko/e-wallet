package ua.lysenko.userservice.ui.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse {

    private String firstName;
    private String lastName;
    private String walletNumber;
    private String token;
}