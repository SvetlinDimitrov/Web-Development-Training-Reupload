package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.Validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final static String PATH_FILE = "src/main/resources/files/json/towns.json";

    public TownServiceImpl(TownRepository townRepository, Gson gson) {
        this.townRepository = townRepository;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() != 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    @Transactional
    public String importTowns() throws IOException {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent() , TownImportDto[].class))
                .forEach(t->{
                   if(!Validate.checkIfItsValid(t) ||
                    townRepository.findByTownName(t.getTownName()).isPresent()){
                       builder.append("Invalid town")
                               .append(System.lineSeparator());
                       return ;
                   }
                   townRepository.save(toTown(t));
                    builder.append(String.format("Successfully imported town %s - %d",
                                    t.getTownName(),
                                    t.getPopulation()))
                            .append(System.lineSeparator());
                });

        return builder.toString();
    }
    private Town toTown(TownImportDto townImportDto){
        return new Town()
                .setTownName(townImportDto.getTownName())
                .setPopulation(townImportDto.getPopulation());
    }
}
