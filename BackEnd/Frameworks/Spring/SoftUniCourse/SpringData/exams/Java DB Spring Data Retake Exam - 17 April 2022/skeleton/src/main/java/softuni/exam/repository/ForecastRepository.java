package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.util.enums.DaysOfTheWeek;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast , Long> {
    Optional<Forecast> findByDaysOfTheWeekAndCity(DaysOfTheWeek daysOfTheWeek , City city);
    @Query("select f from Forecast f " +
            "where f.daysOfTheWeek = :day and f.city.population < 150000 " +
            "order by f.maxTemperature desc , f.id")
    List<Forecast> exportForecasts(DaysOfTheWeek day);
}
