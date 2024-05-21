package ua.lysenko.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@DiscriminatorValue("DEPOSIT")
@Entity
@Getter
@Setter
@SuperBuilder
public class DepositTransaction extends Transaction {
    public DepositTransaction() {
    }
}
