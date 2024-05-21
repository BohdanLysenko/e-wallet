package ua.lysenko.banking.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Entity
@Getter
@Setter
@SuperBuilder
//@Audited
//@AuditOverride(forClass = Auditable.class)
public class Wallet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID walletNumber;

    @Column(name = "user_id", unique = true)
    private Long userId;

    public Wallet() {

    }
}
