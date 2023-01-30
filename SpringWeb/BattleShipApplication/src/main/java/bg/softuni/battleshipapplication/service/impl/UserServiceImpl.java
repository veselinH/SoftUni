package bg.softuni.battleshipapplication.service.impl;

import bg.softuni.battleshipapplication.model.entity.User;
import bg.softuni.battleshipapplication.model.service.UserServiceModel;
import bg.softuni.battleshipapplication.repository.UserRepository;
import bg.softuni.battleshipapplication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
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
        userToRegister.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        userRepository.save(userToRegister);
    }
}
