package com.api.users.services;

import com.api.users.dto.CreateUserDto;
import com.api.users.dto.UpdateUserDto;
import com.api.users.entity.Role;
import com.api.users.entity.User;
import com.api.users.repository.RoleRepository;
import com.api.users.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User create(CreateUserDto dto) {
     if (userRepository.existsByUsername(dto.getUsername()))
         throw new RuntimeException("Username already exists");

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Set<Role> roles = new HashSet<>();
        if (dto.getRoleIds() != null && !dto.getRoleIds().isEmpty())
            roles.addAll(roleRepository.findAllById(dto.getRoleIds()));

        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User update(Long id, UpdateUserDto dto) {
        return userRepository.findById(id).map(user -> {
            if (dto.getUsername() != null) user.setUsername(dto.getUsername());
            if (dto.getPassword() != null) user.setPassword(dto.getPassword());
            if (dto.getRoleIds() != null) {
                Set<Role> roles = new HashSet<>(roleRepository.findAllById(dto.getRoleIds()));
                user.setRoles(roles);
            }
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}