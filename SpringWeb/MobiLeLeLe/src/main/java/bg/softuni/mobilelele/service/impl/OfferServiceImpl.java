package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Transmission;
import bg.softuni.mobilelele.model.view.OfferDetailView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.user.CurrentUser;
import bg.softuni.mobilelele.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
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
                .setEngine(Engine.valueOf(offerFromRep.get().getEngine().name()))
                .setTransmission(Transmission.valueOf(offerFromRep.get().getTransmission().name()))
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

    @Override
    public boolean isCreator(Long id) {
        String currentUserFullName = currentUser.getFirstName() + " " + currentUser.getLastName();
        OfferDetailView offerById = getOfferById(id);
        return offerById.getSeller().equals(currentUserFullName);
    }

    @Override
    public void updateOffer(OfferUpdateBindingModel offerUpdateBindingModel) {

        Offer offer = offerRepository
                .findById(offerUpdateBindingModel.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Offer with id " + offerUpdateBindingModel.getId() + " not found!"));

        offer
                .setPrice(offerUpdateBindingModel.getPrice())
                .setEngine(offerUpdateBindingModel.getEngine())
                .setTransmission(offerUpdateBindingModel.getTransmission())
                .setYear(offerUpdateBindingModel.getYear())
                .setDescription(offerUpdateBindingModel.getDescription())
                .setImageUrl(offerUpdateBindingModel.getImageUrl());

        offerRepository.save(offer);


    }
}
