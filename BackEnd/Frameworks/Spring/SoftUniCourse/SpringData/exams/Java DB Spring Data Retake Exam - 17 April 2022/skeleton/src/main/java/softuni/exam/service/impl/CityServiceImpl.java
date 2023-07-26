package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.inport.CityJsonDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.Validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private static final String FILE_PATH = "src/main/resources/files/json/cities.json";
    private final Gson gson;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, Gson gson) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() != 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(gson.fromJson(readCitiesFileContent() , CityJsonDto[].class))
                .forEach(c->{
                    Optional<City> city = cityRepository.findByCityName(c.getCityName());
                    if(city.isPresent() ||
                            !Validate.checkIfItsValid(c) ||
                            c.getCountry() > countryRepository.count()){
                        builder.append("Invalid city")
                                .append(System.lineSeparator());
                        return;
                    }
                    builder.append(String.format("Successfully imported city %s - %d",
                                    c.getCityName(),
                                    c.getPopulation()))
                            .append(System.lineSeparator());

                    cityRepository.save(toCity(c));
                });
        return builder.toString();
    }
    private City toCity(CityJsonDto cityJsonDto){
        return new City().
                setCityName(cityJsonDto.getCityName()).
                setCountry(countryRepository.findById(cityJsonDto.getCountry()).get()).
                setDescription(cityJsonDto.getDescription()).
                setPopulation(cityJsonDto.getPopulation());
    }
}
