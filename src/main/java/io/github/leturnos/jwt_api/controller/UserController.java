package io.github.leturnos.jwt_api.controller;

import io.github.leturnos.jwt_api.model.User;
import io.github.leturnos.jwt_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAllUsers();
    }
}
