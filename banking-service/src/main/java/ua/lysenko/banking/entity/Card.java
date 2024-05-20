package ua.lysenko.banking.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
//@Audited
//@AuditOverride(forClass = Auditable.class)
@Table(name = "cards")
public class Card extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    private String cardNumber;
    private Date expirationDate;

    @ManyToOne
    private Wallet wallet;
    @Column(nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT false")
    private boolean isActive;

    private int cvv;

}
