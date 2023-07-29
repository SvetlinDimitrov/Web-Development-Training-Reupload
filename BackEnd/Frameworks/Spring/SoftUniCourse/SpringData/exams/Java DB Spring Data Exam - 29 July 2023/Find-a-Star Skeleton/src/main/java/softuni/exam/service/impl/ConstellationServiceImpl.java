package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.Validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private final ConstellationRepository constellationRepository;
    private final Gson gson;

    private final Set<String> names = new HashSet<>();
    private final static String PATH_FILE = "src/main/resources/files/json/constellations.json";

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() != 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class))
                .forEach(c -> {

                    if (!Validate.checkIfItsValid(c) ||
                            names.contains(c.getName())
                    ){
                        builder.append("Invalid constellation")
                                .append(System.lineSeparator());

                        return;
                    }

                    names.add(c.getName());

                    Constellation constellation = toConstellation(c);
                    constellationRepository.save(constellation);

                    builder.append(String.format("Successfully imported constellation %s - %s",
                                    c.getName(),
                                    c.getDescription()))
                            .append(System.lineSeparator());
                });

        return builder.toString();
    }
    private Constellation toConstellation(ConstellationImportDto dto){
        return new Constellation()
                .setName(dto.getName())
                .setDescription(dto.getDescription());
    }
}
