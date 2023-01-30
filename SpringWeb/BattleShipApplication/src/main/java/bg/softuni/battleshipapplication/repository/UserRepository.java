package bg.softuni.battleshipapplication.repository;

import bg.softuni.battleshipapplication.model.entity.User;
import bg.softuni.battleshipapplication.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
