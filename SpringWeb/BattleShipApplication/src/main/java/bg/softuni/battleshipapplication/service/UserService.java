package bg.softuni.battleshipapplication.service;

import bg.softuni.battleshipapplication.model.entity.User;
import bg.softuni.battleshipapplication.model.service.UserServiceModel;

public interface UserService {
    User findUserByEmail(String email);

    User findUserByUsername(String username);

    void registerUser(UserServiceModel userServiceModel);
}
