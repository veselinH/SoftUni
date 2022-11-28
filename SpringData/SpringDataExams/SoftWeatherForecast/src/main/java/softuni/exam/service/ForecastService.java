package softuni.exam.service;

import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.Day;

import javax.swing.text.html.Option;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;


public interface ForecastService {

    boolean areImported();

    String readForecastsFromFile() throws IOException;
	
	String importForecasts() throws IOException, JAXBException;

    String exportForecasts();

    Optional<Forecast> findForecastByDayAndCityId(Day day, Long id);
}
