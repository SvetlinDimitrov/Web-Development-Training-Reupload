package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.inport.CountriesJsonDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.Validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private static final String FILE_PATH = "src/main/resources/files/json/countries.json";
    private final Gson gson;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson) {
        this.countryRepository = countryRepository;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() != 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(gson.fromJson(readCountriesFromFile(), CountriesJsonDto[].class))
                .forEach(c -> {
                    Optional<Country> name = countryRepository.findByCountryName(c.getCountryName());
                    if (name.isPresent() || !Validate.checkIfItsValid(c)) {
                        builder.append("Invalid country")
                                .append(System.lineSeparator());
                        return;
                    }
                    builder.append(String.format("Successfully imported country %s - %s",
                                    c.getCountryName(),
                                    c.getCurrency()))
                            .append(System.lineSeparator());

                    countryRepository.save(toCountry(c));
                });
        return builder.toString();
    }

    private Country toCountry(CountriesJsonDto countriesJsonDto) {
        return new Country().
                setCountryName(countriesJsonDto.getCountryName()).
                setCurrency(countriesJsonDto.getCurrency());
    }
}
