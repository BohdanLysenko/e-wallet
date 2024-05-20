package ua.lysenko.userserivce.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    public static void appendToMessage(StringBuilder messageBuilder, String additionalMessage) {
        if (messageBuilder.length() > 0) {
            messageBuilder.append(". ");
        }
        messageBuilder.append(additionalMessage);
    }

    public static String convertObjectToJson(Object object) throws JsonProcessingException {
        return (object != null) ? MapperUtils.writeValueAsString(object) : null;
    }
}