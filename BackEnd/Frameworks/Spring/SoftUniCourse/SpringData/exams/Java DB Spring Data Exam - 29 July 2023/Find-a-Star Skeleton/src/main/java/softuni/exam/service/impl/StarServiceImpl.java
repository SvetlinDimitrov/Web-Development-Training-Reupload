package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.Validate;
import softuni.exam.util.enums.StarType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class StarServiceImpl implements StarService {
    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final Set<String> names = new HashSet<>();
    private final static String PATH_FILE = "src/main/resources/files/json/stars.json";

    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, Gson gson) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() != 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(gson.fromJson(readStarsFileContent(), StarImportDto[].class))
                .forEach(s -> {

                    if (!Validate.checkIfItsValid(s) ||
                            names.contains(s.getName())
                    ) {

                        builder.append("Invalid star")
                                .append(System.lineSeparator());

                        return;
                    }

                    names.add(s.getName());

                    Star star = toStar(s);
                    starRepository.save(star);

                    builder.append(String.format("Successfully imported star %s - %.2f light years",
                                    s.getName(),
                                    s.getLightYears()))
                            .append(System.lineSeparator());


                });

        return builder.toString();
    }

    @Override
    @Transactional
    public String exportStars() {
        StringBuilder builder = new StringBuilder();

        starRepository.extractsSpecificStars(StarType.RED_GIANT)
                .forEach(s -> {

                    builder.append(String.format("Star: %s",
                                    s.getName()))
                            .append(System.lineSeparator())
                            .append(String.format("   *Distance: %.2f light years",
                                    s.getLightYears()))
                            .append(System.lineSeparator())
                            .append(String.format("   **Description: %s",
                                    s.getDescription()))
                            .append(System.lineSeparator())
                            .append(String.format("   ***Constellation: %s",
                                    s.getConstellation().getName()))
                            .append(System.lineSeparator());

                });

        return builder.toString();
    }

    private Star toStar(StarImportDto dto) {
        return new Star()
                .setName(dto.getName())
                .setLightYears(dto.getLightYears())
                .setDescription(dto.getDescription())
                .setStar(dto.getStar())
                .setConstellation(constellationRepository.findById(dto.getConstellation()).orElseThrow(() -> new RuntimeException("SoftUni lied about the constellation id to be valid")));
    }
}
