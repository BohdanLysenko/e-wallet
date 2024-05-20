package ua.lysenko.banking.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
//@Audited
//@AuditOverride(forClass = Auditable.class)
public class Wallet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID walletNumber;

    @Column(name = "user_id", unique = true)
    private Long userID;

    public String getWalletNumber() {
        return walletNumber.toString();
    }
}
