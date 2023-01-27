package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.view.OfferDetailView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {

        model.addAttribute("offers",
                offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOffer(@PathVariable Long id, OfferDetailView offerDetailView, Model model) {

        model.addAttribute("offerById",
                offerService.getOfferById(id));
        return "details";
    }

    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id){
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/offers/{id}/update")
    public String updateOffer(@PathVariable Long id){
        return "update";
    }
}
