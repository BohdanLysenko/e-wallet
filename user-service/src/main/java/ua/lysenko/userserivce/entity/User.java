package ua.lysenko.userserivce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    @Pattern(regexp = "^(?!\\s*$).+",
            message = "invalid_name")
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 120, unique = true)
    @Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
            + "(?:[A-Za-z0-9-]*[A-Za-z0-9])?",
            message = "invalid_email")
    private String email;


    @Column(nullable = false)
    private String encryptedPassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT false")
    private boolean isSuspiciousActivityDetected;
    @Column(nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT false")
    private boolean isTransactionBlocked;
    @Column(nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT true")
    private boolean enabled = true;

    @CreationTimestamp
    @Column(updatable = false)
    private ZonedDateTime createdAt;

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return encryptedPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now(ZoneId.of("GMT+3"));
    }
}