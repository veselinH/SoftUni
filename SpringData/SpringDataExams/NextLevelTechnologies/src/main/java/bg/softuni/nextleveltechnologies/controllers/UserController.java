package bg.softuni.nextleveltechnologies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/users/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("users/login")
    public String doLogin()

    {
        return "user/login";
    }

}
