package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastSeedRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.Day;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final CityService cityService;
    private final ModelMapper modelMapper;

    public ForecastServiceImpl(ForecastRepository forecastRepository, XmlParser xmlParser, ValidationUtil validationUtil, CityService cityService, ModelMapper modelMapper) {
        this.forecastRepository = forecastRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files
                .readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(FORECAST_FILE_PATH, ForecastSeedRootDto.class)
                .getForecasts()
                .stream()
                .filter(forecastSeedDto -> {
                    boolean isValid = validationUtil.isValid(forecastSeedDto);

                    Optional<Forecast> forecast =
                            findForecastByDayAndCityId(forecastSeedDto.getDayOfWeek(), forecastSeedDto.getCity());

                    if (forecast.isPresent()) {
                        isValid = false;
                    }
                    if (forecastSeedDto.getMaxTemperature() < -20.00 || forecastSeedDto.getMaxTemperature() > 60.00) {
                        isValid = false;
                    }
                    if (forecastSeedDto.getMinTemperature() < -50.00 || forecastSeedDto.getMinTemperature() > 40.00) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully import forecast %s - %.2f",
                                    forecastSeedDto.getDayOfWeek(), forecastSeedDto.getMaxTemperature())
                                    : "Invalid forecast")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(forecastSeedDto -> {
                    Forecast forecast = modelMapper.map(forecastSeedDto, Forecast.class);
                    forecast.setCity(cityService.findCityById(forecastSeedDto.getCity()));

                    return forecast;
                })
                .forEach(forecastRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();

        Day day = Day.SUNDAY;
        Integer population = 150000;

        forecastRepository
                .findAllByDayOfWeekAndCityPopulationOrderedByMaxTemperatureDescAndId(day, population)
                .forEach(forecast -> {
                    City city = cityService.findCityById(forecast.getCity().getId());
                    sb.
                            append(String.format("City: %s:\n" +
                                            "   \t\t-min temperature: %.2f\n" +
                                            "   \t\t--max temperature: %.2f\n" +
                                            "   \t\t---sunrise: %s\n" +
                                            "----sunset: %s\n",
                                    city.getCityName(),
                                    forecast.getMinTemperature(),
                                    forecast.getMaxTemperature(),
                                    forecast.getSunrise(),
                                    forecast.getSunset()));
                });

        return sb.toString().trim();
    }

    @Override
    public Optional<Forecast> findForecastByDayAndCityId(Day day, Long id) {
        return forecastRepository.findByDayOfWeekAndAndCity_Id(day, id);
    }
}
