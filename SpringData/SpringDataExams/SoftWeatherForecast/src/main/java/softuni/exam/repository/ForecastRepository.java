package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.Day;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Forecast findByCity_Id(Long cityId);

    Optional<Forecast> findByDayOfWeekAndAndCity_Id(Day day, Long id);

    @Query("SELECT f FROM Forecast f " +
            "WHERE f.dayOfWeek = :day AND f.city.population < :population " +
            "ORDER BY f.maxTemperature DESC, f.id")
    List<Forecast> findAllByDayOfWeekAndCityPopulationOrderedByMaxTemperatureDescAndId
            (@Param(value = "day") Day day, @Param(value = "population") Integer population);
}
