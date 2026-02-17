package io.github.leturnos.jwt_api;

import io.github.leturnos.jwt_api.model.Role;
import io.github.leturnos.jwt_api.model.User;
import io.github.leturnos.jwt_api.service.RoleService;
import io.github.leturnos.jwt_api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApiApplication.class, args);
	}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(RoleService roleService, UserService userService) {
        return args -> {
            roleService.saveRole(new Role("ROLE_USER"));
            roleService.saveRole(new Role("ROLE_ADMIN"));
            roleService.saveRole(new Role("ROLE_MASTER"));

            userService.saveUser(new User("Ana", "ana@gmail.com", "123456"));
            userService.saveUser(new User("Pedro", "pedro@gmail.com", "123456"));
            userService.saveUser(new User("Leturnos", "leturnos@gmail.com", "123456"));

            userService.addRoleToUser("ana@gmail.com", "ROLE_USER");
            userService.addRoleToUser("pedro@gmail.com", "ROLE_ADMIN");
            userService.addRoleToUser("leturnos@gmail.com", "ROLE_MASTER");
        };
    }

}
