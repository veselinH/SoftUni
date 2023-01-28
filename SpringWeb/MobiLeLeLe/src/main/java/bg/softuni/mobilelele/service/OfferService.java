package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.model.service.OfferUpdateServiceModel;
import bg.softuni.mobilelele.model.view.OfferDetailView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {

    List<OfferSummaryView> getAllOffers();

    OfferDetailView getOfferById(Long id);

    void deleteOffer(Long id);
    boolean isCreator(Long id);

    void updateOffer(OfferUpdateBindingModel offerUpdateBindingModel);
}
