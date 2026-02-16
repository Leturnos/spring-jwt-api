package io.github.leturnos.jwt_api.service;

import io.github.leturnos.jwt_api.model.Role;
import io.github.leturnos.jwt_api.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName).orElseThrow();
    }
}
