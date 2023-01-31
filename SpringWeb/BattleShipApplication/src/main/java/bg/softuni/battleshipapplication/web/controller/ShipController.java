package bg.softuni.battleshipapplication.web.controller;

import bg.softuni.battleshipapplication.model.binding.ShipAddBindingModel;
import bg.softuni.battleshipapplication.sec.CurrentUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {



    private final CurrentUser currentUser;

    public ShipController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        if (currentUser.getId() == null){
            return "redirect:/users/login";
        }

        return "ship-add";
    }

    @PostMapping("/add")
    public String addShip(@Valid ShipAddBindingModel shipAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);

            return "redirect:add";
        }
//
//        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
//            result.addError(
//                    new FieldError(
//                            "differentConfirmPassword",
//                            "confirmPassword",
//                            "Passwords must be the same."));
//        }



        return "redirect:/";
    }
}
