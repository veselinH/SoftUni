package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Transmission;
import bg.softuni.mobilelele.model.service.OfferUpdateServiceModel;
import bg.softuni.mobilelele.model.view.OfferDetailView;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.user.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {

        model.addAttribute("offers",
                offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOffer(@PathVariable Long id, Model model) {

        model.addAttribute("isCreator",
                offerService.isCreator(id));

        model.addAttribute("isAdmin",
                currentUser.isAdmin());

        model.addAttribute("offerById",
                offerService.getOfferById(id));
        return "details";
    }

    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/offers/{id}/update")
    public String updateOffer(@PathVariable Long id, Model model) {
        OfferDetailView offerById = offerService.getOfferById(id);
        OfferUpdateBindingModel offerModel = modelMapper.map(offerById, OfferUpdateBindingModel.class);
        model.addAttribute("offerModel", offerModel);
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "update";
    }
    @GetMapping("/offers/{id}/update/errors")
    public String updateOfferErrors(@PathVariable Long id, Model model) {

        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "update";
    }


    // Partial updating we use PATCH otherwise Put
    @PatchMapping("/offers/{id}/update")
    public String updateOffer(@PathVariable Long id,
                              @Valid OfferUpdateBindingModel offerModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            return "redirect:/offers/" + id + "/update/errors";
        }
        offerService.updateOffer(offerModel);

        return "redirect:/offers/" + id + "/details";
    }


}
