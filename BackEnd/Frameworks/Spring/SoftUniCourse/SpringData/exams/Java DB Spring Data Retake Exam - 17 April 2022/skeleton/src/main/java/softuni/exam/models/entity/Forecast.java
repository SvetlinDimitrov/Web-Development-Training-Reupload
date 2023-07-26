package softuni.exam.models.entity;

import softuni.exam.util.enums.DaysOfTheWeek;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Forecast extends BaseEntity {
    //    • day of week – enumerated value, one of the following – FRIDAY, SATURDAY, SUNDAY. Cannot be null.
    //    • max temperature – a floating point number. Must be between -20 and 60 (both numbers are INCLUSIVE). Cannot be null.
    //    • min temperature – a floating point number. Must be between -50 and 40 (both numbers are INCLUSIVE). Cannot be null.
    //    • sunrise – time of the sunrise. Cannot be null.
    //    • sunset – time of the sunset. Cannot be null.
    //    • Constraint: The forecasts table has а relation with the cities table.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false , columnDefinition = "varchar(255)")
    private DaysOfTheWeek daysOfTheWeek;

    @Column(nullable = false , columnDefinition = "double")
    private Double maxTemperature;

    @Column(nullable = false , columnDefinition = "double")
    private Double minTemperature;

    @Column(nullable = false , columnDefinition = "time")
    private LocalTime sunrise;

    @Column(nullable = false , columnDefinition = "time")
    private LocalTime sunset;

    @ManyToOne
    private City city;

    public DaysOfTheWeek getDaysOfTheWeek() {
        return daysOfTheWeek;
    }

    public Forecast setDaysOfTheWeek(DaysOfTheWeek daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
        return this;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public Forecast setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public Forecast setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
        return this;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public Forecast setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public Forecast setSunset(LocalTime sunset) {
        this.sunset = sunset;
        return this;
    }

    public City getCity() {
        return city;
    }

    public Forecast setCity(City city) {
        this.city = city;
        return this;
    }
}
