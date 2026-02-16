package io.github.leturnos.jwt_api.controller;

import io.github.leturnos.jwt_api.model.Role;
import io.github.leturnos.jwt_api.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @PostMapping
    public Role save(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAllRoles();
    }
}
