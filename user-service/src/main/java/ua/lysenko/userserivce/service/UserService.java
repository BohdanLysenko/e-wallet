package ua.lysenko.userserivce.service;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.lysenko.userserivce.dto.UserDTO;
import ua.lysenko.userserivce.entity.User;

import java.util.List;

public interface UserService {

    User getUserByEmail(String email);

    User getUserById(Long id);

    UserDTO getUserDetailsById(Long id, String token);

    List<UserDTO> getAllUsers(Pageable pageable);

    UserDTO updateUserAdminRole(String userId);

    UserDetailsService userDetailsService();

    void updateUserSuspiciousActivity(Long userId);

    void blockUserById(Long userId);

    void unblockUserById(Long userId);
}
