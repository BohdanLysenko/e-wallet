package ua.lysenko.userservice.service;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.lysenko.userservice.dto.UserDTO;
import ua.lysenko.userservice.entity.User;

import java.util.List;

public interface UserService {

    User getUserByEmail(String email);

    User getUserById(Long id);

    UserDTO getUserDetails(String token);

    List<UserDTO> getAllUsers(Pageable pageable);

    UserDTO updateUserAdminRole(String userId);

    UserDetailsService userDetailsService();

    void updateUserSuspiciousActivityById(Long userId);

    void blockUserById(Long userId);

    void unblockUserById(Long userId);

    void unblockAllUsers();
}
