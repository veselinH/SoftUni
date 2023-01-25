package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.entity.enums.Role;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {

        Optional<User> usernameOpt = userRepository.findByUsername(userLoginServiceModel.getUsername());

        if (usernameOpt.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(
                    userLoginServiceModel.getRawPassword(),
                    usernameOpt.get().getPassword());

            if (success) {
                User loggedInUser = usernameOpt.get();
                login(loggedInUser);
            }

            return success;
        }
    }

    @Override
    public void logout() {
        currentUser.clean();
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel) {

        UserRole userRole = userRoleRepository.findByName(Role.USER);

        User newUser = new User();

        newUser
                .setUsername(userRegisterServiceModel.getUsername())
                .setFirstName(userRegisterServiceModel.getFirstName())
                .setLastName(userRegisterServiceModel.getLastName())
                .setPassword(passwordEncoder.encode(userRegisterServiceModel.getPassword()))
                .setActive(true)
                .setCreated(Instant.now())
                .setRoles(Set.of(userRole));

        userRepository.save(newUser);

        login(newUser);
    }

    private void login(User user) {
        currentUser
                .setLoggedIn(true)
                .setUsername(user.getUsername())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName());
    }


}
