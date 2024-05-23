package ua.lysenko.userserivce.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.lysenko.userserivce.dto.UserDTO;
import ua.lysenko.userserivce.entity.User;
import ua.lysenko.userserivce.ui.models.SignUpRequest;

public interface UserService {

    User getUserByEmail(String email);

    User getUserById(Long id);

    UserDTO getUserDetailsById(Long id, String token);

    UserDTO updateUserAdminRole(String userId);

    UserDetailsService userDetailsService();

    void updateUserSuspiciousActivity(Long userId);
    void disableUser(Long userId);

    void enableUser(Long userId);
}
