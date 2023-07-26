package softuni.exam.models.dto.inport;

import softuni.exam.util.LocalTimeAdapter;
import softuni.exam.util.enums.DaysOfTheWeek;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalTime;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastXmlDto {
    //    • day of week – enumerated value, one of the following – FRIDAY, SATURDAY, SUNDAY. Cannot be null.
    //    • max temperature – a floating point number. Must be between -20 and 60 (both numbers are INCLUSIVE). Cannot be null.
    //    • min temperature – a floating point number. Must be between -50 and 40 (both numbers are INCLUSIVE). Cannot be null.
    //    • sunrise – time of the sunrise. Cannot be null.
    //    • sunset – time of the sunset. Cannot be null.
    //    • Constraint: The forecasts table has а relation with the cities table.
    @XmlElement(name = "day_of_week")
    @NotNull
    private DaysOfTheWeek daysOfTheWeek;

    @XmlElement(name = "max_temperature")
    @DecimalMin(value = "-20.0")
    @DecimalMax(value = "60.0")
    @NotNull
    private Double maxTemperature;

    @XmlElement(name = "min_temperature")
    @DecimalMin(value = "-50.0")
    @DecimalMax(value = "40.0")
    @NotNull
    private Double minTemperature;

    @XmlElement(name = "sunrise")
    @NotNull
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    private LocalTime sunrise;

    @XmlElement(name = "sunset")
    @NotNull
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    private LocalTime sunset;

    @XmlElement(name = "city")
    @NotNull
    private Long city;

    public DaysOfTheWeek getDaysOfTheWeek() {
        return daysOfTheWeek;
    }

    public ForecastXmlDto setDaysOfTheWeek(DaysOfTheWeek daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
        return this;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public ForecastXmlDto setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public ForecastXmlDto setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
        return this;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public ForecastXmlDto setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public ForecastXmlDto setSunset(LocalTime sunset) {
        this.sunset = sunset;
        return this;
    }

    public Long getCity() {
        return city;
    }

    public ForecastXmlDto setCity(Long city) {
        this.city = city;
        return this;
    }
}
