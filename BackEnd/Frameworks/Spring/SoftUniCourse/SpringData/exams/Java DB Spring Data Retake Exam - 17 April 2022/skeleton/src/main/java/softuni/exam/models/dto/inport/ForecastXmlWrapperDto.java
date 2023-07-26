package softuni.exam.models.dto.inport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastXmlWrapperDto {
    @XmlElement(name = "forecast")
    private List<ForecastXmlDto> forecasts;

    public List<ForecastXmlDto> getForecasts() {
        return forecasts;
    }

    public ForecastXmlWrapperDto setForecasts(List<ForecastXmlDto> forecasts) {
        this.forecasts = forecasts;
        return this;
    }
}
