package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfficeService;

import java.util.List;
import java.util.stream.Collectors;

public class OfficeServiceImpl implements OfficeService {

    private final OfferRepository offerRepository;

    public OfficeServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return
                offerRepository
                        .findAll()
                        .stream()
                        .map(this::map)
                        .collect(Collectors.toList());
    }

    private OfferSummaryView map(Offer offer) {

        //TODO
        return new OfferSummaryView();
    }
}
