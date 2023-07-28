package com.example.football.service.impl;

import com.example.football.models.dto.StatImportDto;
import com.example.football.models.dto.StatImportWrapperDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.Validate;
import com.example.football.util.XmlParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class StatServiceImpl implements StatService {
    private StatRepository statRepository;
    private final static Set<Double> set = new HashSet<>();
    private final static String PATH_FILE = "src/main/resources/files/xml/stats.xml";

    @Override
    public boolean areImported() {
        return statRepository.count() != 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder builder = new StringBuilder();

        XmlParser.fromFile(Path.of(PATH_FILE).toFile() , StatImportWrapperDto.class)
                .getList()
                .forEach(s->{

                    if(!Validate.checkIfItsValid(s) ||
                        set.contains(s.getEndurance()+s.getPassing()+s.getShooting())){

                        builder.append("Invalid Stat")
                                .append(System.lineSeparator());
                        return;
                    }

                    set.add(s.getEndurance()+s.getPassing()+s.getShooting());
                    Stat stat = toStat(s);
                    statRepository.save(stat);

                    builder.append(String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                                    s.getShooting(),
                                    s.getPassing(),
                                    s.getEndurance()))
                            .append(System.lineSeparator());

                });

        return builder.toString();
    }

    private Stat toStat(StatImportDto dto){
        return Stat.builder()
                .shooting(dto.getShooting())
                .passing(dto.getPassing())
                .endurance(dto.getEndurance())
                .build();
    }
}
