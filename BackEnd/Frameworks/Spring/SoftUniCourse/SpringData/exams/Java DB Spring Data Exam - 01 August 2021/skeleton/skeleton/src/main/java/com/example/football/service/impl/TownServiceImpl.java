package com.example.football.service.impl;

import com.example.football.models.dto.TownImportDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.Validate;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@Service
@AllArgsConstructor
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Set<String> set = new HashSet<>();
    private final Gson gson;
    private final static String PATH_FILE = "src/main/resources/files/json/towns.json";

    @Override
    public boolean areImported() {
        return townRepository.count() != 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownImportDto[].class))
                .forEach(t -> {
                            if (!Validate.checkIfItsValid(t) ||
                                    set.contains(t.getName())) {
                                builder.append("Invalid Town")
                                        .append(System.lineSeparator());
                                return;
                            }

                            Town town = toTown(t);
                            set.add(t.getName());
                            townRepository.save(town);

                            builder.append(String.format("Successfully imported Town %s - %d",
                                            t.getName(),
                                            t.getPopulation()))
                                    .append(System.lineSeparator());
                        }
                );

        return builder.toString();
    }

    private Town toTown(TownImportDto townImportDto) {
        return Town.builder()
                .population(townImportDto.getPopulation())
                .name(townImportDto.getName())
                .travelGuide(townImportDto.getTravelGuide())
                .build();
    }
}
