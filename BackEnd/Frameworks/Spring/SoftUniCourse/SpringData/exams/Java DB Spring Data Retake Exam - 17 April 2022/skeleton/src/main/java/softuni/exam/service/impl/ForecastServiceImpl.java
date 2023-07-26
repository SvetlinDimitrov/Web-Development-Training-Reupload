package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.inport.ForecastXmlDto;
import softuni.exam.models.dto.inport.ForecastXmlWrapperDto;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.Validate;
import softuni.exam.util.XmlParser;
import softuni.exam.util.enums.DaysOfTheWeek;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {
    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private static final String FILE_PATH = "src/main/resources/files/xml/forecasts.xml";
    private final XmlParser xmlParser;

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, XmlParser xmlParser) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() != 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();

        xmlParser.fromFile(Path.of(FILE_PATH).toFile() , ForecastXmlWrapperDto.class)
                .getForecasts()
                .forEach(f->{
                    if(!Validate.checkIfItsValid(f) ||
                            cityRepository.count() < f.getCity() ||
                            forecastRepository.findByDaysOfTheWeekAndCity(f.getDaysOfTheWeek() ,
                                    cityRepository.findById(f.getCity()).get()).isPresent()
                    ){
                        builder.append("Invalid forecast")
                                .append(System.lineSeparator());
                        return;
                    }
                    builder.append(String.format("Successfully import forecast %s - %.2f",
                                    f.getDaysOfTheWeek() ,
                                    f.getMaxTemperature()))
                            .append(System.lineSeparator());

                    forecastRepository.save(toForecast(f));

                });

        return builder.toString();
    }

    @Override
    @Transactional
    public String exportForecasts() {
        StringBuilder builder = new StringBuilder();

        forecastRepository.exportForecasts(DaysOfTheWeek.SUNDAY)
                .forEach(f->
                    builder.append(String.format("City: %s",f.getCity().getCityName()))
                            .append(System.lineSeparator())
                            .append(String.format("-min temperature: %.2f",f.getMinTemperature()))
                            .append(System.lineSeparator())
                            .append(String.format("--max temperature: %.2f",f.getMaxTemperature()))
                            .append(System.lineSeparator())
                            .append(String.format("---sunrise: %s",f.getSunrise()))
                            .append(System.lineSeparator())
                            .append(String.format("----sunset: %s",f.getSunset()))
                            .append(System.lineSeparator())
                );

        return builder.toString();
    }

    private Forecast toForecast(ForecastXmlDto forecastXmlDto){
        return new Forecast()
                .setCity(cityRepository.findById(forecastXmlDto.getCity()).get())
                .setDaysOfTheWeek(forecastXmlDto.getDaysOfTheWeek())
                .setMaxTemperature(forecastXmlDto.getMaxTemperature())
                .setSunset(forecastXmlDto.getSunset())
                .setSunrise(forecastXmlDto.getSunrise())
                .setMinTemperature(forecastXmlDto.getMinTemperature());
    }
}
