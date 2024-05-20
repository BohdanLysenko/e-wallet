package ua.lysenko.userserivce.exceptions.Responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiExceptionModel {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

}
