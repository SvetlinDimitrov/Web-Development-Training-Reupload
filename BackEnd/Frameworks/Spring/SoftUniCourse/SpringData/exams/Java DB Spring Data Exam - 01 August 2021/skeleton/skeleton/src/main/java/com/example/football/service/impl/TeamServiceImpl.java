package com.example.football.service.impl;

import com.example.football.models.dto.TeamImportDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.Validate;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final Set<String> set = new HashSet<>();
    private final static String PATH_FILE = "src/main/resources/files/json/teams.json";

    @Override
    public boolean areImported() {
        return teamRepository.count() != 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent() , TeamImportDto[].class))
                .forEach(t->{
                    if(!Validate.checkIfItsValid(t) ||
                    set.contains(t.getName())){
                        builder.append("Invalid Team")
                                .append(System.lineSeparator());
                        return;
                    }

                    set.add(t.getName());
                    Team team = toTeam(t);
                    teamRepository.save(team);

                    builder.append(String.format("Successfully imported Team %s - %d",
                                    t.getName(),
                                    t.getFanBase()))
                            .append(System.lineSeparator());
                });

        return builder.toString();
    }


    private Team toTeam(TeamImportDto dto){
        return Team.builder()
                .name(dto.getName())
                .stadiumName(dto.getStadiumName())
                .fanBase(dto.getFanBase())
                .history(dto.getHistory())
                .town(townRepository.findByName(dto.getTownName()).orElseThrow(() -> new RuntimeException("SoftUni lied townName does not exist")))
                .build();
    }
}
