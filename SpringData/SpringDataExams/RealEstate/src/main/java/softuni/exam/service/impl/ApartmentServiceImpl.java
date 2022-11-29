package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentRootSeedDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";
    private final ApartmentRepository apartmentRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, TownService townService) {
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files
                .readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(APARTMENTS_FILE_PATH, ApartmentRootSeedDTO.class)
                .getApartments()
                .stream()
                .filter(apartmentSeedDTO -> {
                    boolean isValid = validationUtil.isValid(apartmentSeedDTO);

                    Apartment apartmentFromDataBase =
                            findApartmentByTownNameAndPopulation(apartmentSeedDTO.getTown(), apartmentSeedDTO.getArea());

                    if (apartmentFromDataBase != null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported apartment %s - %.2f",
                                    apartmentSeedDTO.getApartmentType(), apartmentSeedDTO.getArea())
                                    : "Invalid apartment")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(apartmentSeedDTO -> {
                    Apartment apartment = modelMapper.map(apartmentSeedDTO, Apartment.class);

                    Town town = townService.findTownByName(apartmentSeedDTO.getTown());
                    apartment.setTown(town);

                    return apartment;
                })
                .forEach(apartmentRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Apartment findApartmentByTownNameAndPopulation(String townName, Double area) {
        return apartmentRepository.findByTown_TownNameAndArea(townName, area)
                .orElse(null);
    }

}
