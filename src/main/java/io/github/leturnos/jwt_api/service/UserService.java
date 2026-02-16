package io.github.leturnos.jwt_api.service;

import io.github.leturnos.jwt_api.model.Role;
import io.github.leturnos.jwt_api.model.User;
import io.github.leturnos.jwt_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email).orElseThrow();
        Role role = roleService.findRoleByName(roleName);

        user.getRoles().add(role);
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
