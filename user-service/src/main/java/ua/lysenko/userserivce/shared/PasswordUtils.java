package ua.lysenko.userserivce.shared;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encode(CharSequence password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static PasswordEncoder passwordEncoder() {
        return bCryptPasswordEncoder;
    }
}