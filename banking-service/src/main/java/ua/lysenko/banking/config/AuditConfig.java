package ua.lysenko.banking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ua.lysenko.banking.utils.BankingAuditorAware;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "bankingAuditorAware")
public class AuditConfig {

}