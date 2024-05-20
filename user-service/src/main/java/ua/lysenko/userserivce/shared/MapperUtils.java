package ua.lysenko.userserivce.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ua.lysenko.userserivce.dto.UserDTO;
import ua.lysenko.userserivce.entity.User;

@Component
public class MapperUtils extends Utils {

    private static final ModelMapper modelMapper = new ModelMapper();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        typeMapUserDtoUser();
    }

    public static <T, U> U map(T source, Class<U> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public static String writeValueAsString(Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsString(value);
    }

    private static void typeMapUserDtoUser() {
        modelMapper.typeMap(UserDTO.class, User.class)
                .addMapping(UserDTO::getPassword, User::setEncryptedPassword);
    }
}