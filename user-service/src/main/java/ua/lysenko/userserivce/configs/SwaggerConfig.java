package ua.lysenko.userserivce.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Bohdan Lysenko");
        contact.setEmail("lysenbogdan@gmail.com");
        return new OpenAPI()
                .info(new Info()
                        .title("eWallet API")
                        .version("1.0")
                        .contact(contact)
                        .description("This is a functional e-wallet Java application that allows users to store, transfer, and manage funds through an exposed API"));
    }
}