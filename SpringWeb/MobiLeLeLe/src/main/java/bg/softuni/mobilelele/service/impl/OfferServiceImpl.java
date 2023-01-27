package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.entity.enums.Transmission;
import bg.softuni.mobilelele.model.view.OfferDetailView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public OfferDetailView getOfferById(Long id) {
        Optional<Offer> offerFromRep = offerRepository.findById(id);

        OfferDetailView offerById = modelMapper.map(offerFromRep, OfferDetailView.class);

        boolean modified = true;

        if (offerFromRep.get().getModified() == null) {
            modified = false;
        }

        offerById
                .setEngineType(offerFromRep.get().getEngine().getValue())
                .setTransmissionType(Transmission.valueOf(offerFromRep.get().getTransmission().name()))
                .setModified(modified ? offerFromRep.get().getModified() : offerFromRep.get().getCreated())
                .setSeller(
                        offerFromRep.get().getSeller().getFirstName() +
                                " " +
                                offerFromRep.get().getSeller().getLastName())
                .setBrand(offerFromRep.get().getModel().getBrand().getName())
                .setModel(offerFromRep.get().getModel().getName());
        return offerById;
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    private OfferSummaryView map(Offer offer) {

        OfferSummaryView summaryView = this.modelMapper
                .map(offer, OfferSummaryView.class);
        //TODO
        return summaryView;
    }
}
