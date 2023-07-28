package com.example.football.service.impl;

import com.example.football.models.dto.PlayerImportDto;
import com.example.football.models.dto.PlayerImportWrapperDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.Validate;
import com.example.football.util.XmlParser;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final StatRepository statRepository;
    private final static Set<String> setEmail = new HashSet<>();
    private final static String PATH_FILE = "src/main/resources/files/xml/players.xml";

    @Override
    public boolean areImported() {
        return playerRepository.count() != 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder builder = new StringBuilder();
        long maxIdOfState = statRepository.count();

        XmlParser.fromFile(Path.of(PATH_FILE).toFile(), PlayerImportWrapperDto.class)
                .getList()
                .forEach(p -> {

                    if (!Validate.checkIfItsValid(p) ||
                            !Validate.checkIfItsValid(p.getStat()) ||
                            !Validate.checkIfItsValid(p.getTeam()) ||
                            !Validate.checkIfItsValid(p.getTown()) ||
                            maxIdOfState < p.getStat().getId() ||
                            setEmail.contains(p.getEmail())) {

                        builder.append("Invalid Player")
                                .append(System.lineSeparator());
                        return;
                    }

                    setEmail.add(p.getEmail());
                    Player player = toPlayer(p);
                    playerRepository.save(player);

                    builder.append(String.format("Successfully imported Player %s %s - %s",
                                    p.getFirstName(),
                                    p.getLastName(),
                                    p.getPosition().name()))
                            .append(System.lineSeparator());

                });

        return builder.toString();
    }

    @Override
    @Transactional
    public String exportBestPlayers() {

        StringBuilder builder = new StringBuilder();
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        playerRepository.exportSpecificPlayers(LocalDate.parse("01-01-1995", dateTimeFormat),
                        LocalDate.parse("01-01-2003", dateTimeFormat))
                .forEach(p -> {

                    builder.append(String.format("Player - %s %s",
                                    p.getFirstName(),
                                    p.getLastName()))
                            .append(System.lineSeparator())
                            .append(String.format("     Position - %s",
                                    p.getPosition().name()))
                            .append(System.lineSeparator())
                            .append(String.format("     Team - %s",
                                    p.getTeam().getName()))
                            .append(System.lineSeparator())
                            .append(String.format("     Stadium - %s",
                                    p.getTeam().getStadiumName()))
                            .append(System.lineSeparator());
                });

        return builder.toString();
    }


    private Player toPlayer(PlayerImportDto dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return Player.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .birthDate(LocalDate.parse(dto.getBirthDate(), formatter))
                .position(dto.getPosition())
                .town(townRepository.findByName(dto.getTown().getName()).orElseThrow(() -> new RuntimeException("softUni lied about the validation of TownName")))
                .team(teamRepository.findByName(dto.getTeam().getName()).orElseThrow(() -> new RuntimeException("softUni lied about the validation of TeamName")))
                .stat(statRepository.findById(dto.getStat().getId()).orElseThrow(() -> new RuntimeException("softUni lied about the validation of StateId")))
                .build();
    }
}
