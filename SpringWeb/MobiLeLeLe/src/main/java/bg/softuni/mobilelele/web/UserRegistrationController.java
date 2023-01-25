package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegistrationController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/users/register")
    public String registerUser() {
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(@Valid UserRegisterBindingModel userRegisterBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:/users/register";
        }

        UserRegisterServiceModel serviceMode =
                modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class);

        if (!userService.isUserNameFree(userRegisterBindingModel.getUsername())) {
            // TODO - add to flash attributes
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("userNameOccupied", true);
            return "redirect:/users/register";
        } else {
            userService.registerAndLoginUser(serviceMode);
            return "redirect:/";
        }

    }
}
