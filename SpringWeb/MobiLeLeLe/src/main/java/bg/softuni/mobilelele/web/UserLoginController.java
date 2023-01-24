package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel) {

        boolean loginSuccessful = userService.login(
                new UserLoginServiceModel()
                        .setUsername(userLoginBindingModel.getUsername())
                        .setRawPassword(userLoginBindingModel.getPassword())
        );

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                userLoginBindingModel.getUsername(),
                loginSuccessful);


        return "redirect:/users/login";
    }

}
