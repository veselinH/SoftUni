package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.entity.enums.Role;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@Component
public class DBInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initUsers();
    }

    public void initUsers() {

        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setName(Role.ADMIN);
            userRoleRepository.save(adminRole);

            UserRole userRole = new UserRole();
            userRole.setName(Role.USER);
            userRoleRepository.save(userRole);
        }

        if (userRepository.count() == 0) {
            UserRole adminRole = userRoleRepository.findByName(Role.ADMIN);
            UserRole userRole = userRoleRepository.findByName(Role.USER);

            User admin = new User();

            admin
                    .setActive(true)
                    .setUsername("admin")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("test"))
                    .setCreated(Instant.now())
                    .setRoles(Set.of(adminRole, userRole));

            userRepository.save(admin);

            User user = new User();

            user
                    .setActive(true)
                    .setUsername("vesko")
                    .setFirstName("Veselin")
                    .setLastName("Hristov")
                    .setPassword(passwordEncoder.encode("1234"))
                    .setRoles(Set.of(userRole));

            userRepository.save(user);

        }
    }
}
