package bg.softuni.battleshipapplication.service.impl;

import bg.softuni.battleshipapplication.model.entity.User;
import bg.softuni.battleshipapplication.model.service.UserServiceModel;
import bg.softuni.battleshipapplication.repository.UserRepository;
import bg.softuni.battleshipapplication.sec.CurrentUser;
import bg.softuni.battleshipapplication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElse(null);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElse(null);
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User userToRegister = modelMapper.map(userServiceModel, User.class);
//        userToRegister.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        userRepository.save(userToRegister);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(UserServiceModel userServiceModel) {
        System.out.println();
        Optional<User> userFromRepo = userRepository.findByUsernameAndPassword(userServiceModel.getUsername(), userServiceModel.getPassword());

        if (userFromRepo.isPresent()) {
            UserServiceModel mappedUser = new UserServiceModel();
            mappedUser
                    .setId(userFromRepo.get().getId())
                    .setUsername(userFromRepo.get().getUsername())
                    .setPassword(userFromRepo.get().getPassword());

            return mappedUser;
        } else {
            return null;
        }

//        return userRepository
//                .findByUsernameAndPassword(userServiceModel.getUsername(), userServiceModel.getPassword())
//                .map(user -> modelMapper.map(user, UserServiceModel.class))
//                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String password) {
        currentUser.setId(id).setUsername(password);
    }
}
