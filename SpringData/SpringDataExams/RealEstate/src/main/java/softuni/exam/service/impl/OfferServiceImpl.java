package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferRootSeedDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFERS_PATH_FILE = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final AgentService agentService;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ValidationUtil validationUtil, AgentService agentService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.agentService = agentService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files
                .readString(Path.of(OFFERS_PATH_FILE));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(OFFERS_PATH_FILE, OfferRootSeedDTO.class)
                .getOffers()
                .stream()
                .filter(offerSeedDTO -> {
                    boolean isValid = validationUtil.isValid(offerSeedDTO);

                    Agent agentFromDataBase = agentService.findAgentByFirstName(offerSeedDTO.getAgent().getName());

                    if (agentFromDataBase == null) {
                        isValid = false;
                    }
                    sb
                            .append(isValid ? String.format("Successfully imported offer %.2f",
                                    offerSeedDTO.getPrice())
                                    : "Invalid offer")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(offerSeedDTO -> {
                    Offer offer = modelMapper.map(offerSeedDTO, Offer.class);
                    Agent agent =
                            agentService.findAgentByFirstName(offerSeedDTO.getAgent().getName());

                    offer.setAgent(agent);

                    return offer;
                })
                .forEach(offerRepository::save);


        return sb.toString().trim();
    }

    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();

        ApartmentType apartmentType = ApartmentType.three_rooms;

        findAllOffersByApartmentTypeOrderedByApartmentArea(apartmentType)
                .forEach(sb::append);

        return sb.toString().trim();
    }

    @Override
    public List<String> findAllOffersByApartmentTypeOrderedByApartmentArea(ApartmentType apartmentType) {
        return offerRepository
                .findAllByApartment_ApartmentTypeOrderByApartment_AreaDesc(apartmentType)
                .stream()
                .map(offer -> String.format("Agent %s %s with offer №%d:\n" +
                                "   \t\t-Apartment area: %.2f\n" +
                                "   \t\t--Town: %s\n" +
                                "   \t\t---Price: %.2f$\n",
                        offer.getAgent().getFirstName(),
                        offer.getAgent().getLastName(),
                        offer.getId(),
                        offer.getApartment().getArea(),
                        offer.getApartment().getTown().getTownName(),
                        offer.getPrice()))
                .collect(Collectors.toList());
    }
}
