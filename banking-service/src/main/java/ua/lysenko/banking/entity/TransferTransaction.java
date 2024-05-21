package ua.lysenko.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DiscriminatorValue("TRANSFER")
@Entity
@Getter
@Setter
public class TransferTransaction extends Transaction {

    private Long destinationCardId;

}
