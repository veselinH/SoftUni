package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.service.OfficeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfferController {

    private final OfficeService officeService;

    public OfferController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model){

        model.addAttribute("offers",
                officeService.getAllOffers());
        return "offers";
    }
}
