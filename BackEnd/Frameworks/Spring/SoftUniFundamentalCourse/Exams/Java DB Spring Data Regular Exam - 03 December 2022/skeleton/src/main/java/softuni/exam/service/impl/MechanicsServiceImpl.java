package softuni.exam.service.impl;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.MechanicJsonImportDto;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.Validate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class MechanicsServiceImpl implements MechanicsService {
    private MechanicsRepository mechanicsRepository;
    private Gson gson;
    private final static String MECHANICAL_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    @Override
    public boolean areImported() {
        return mechanicsRepository.count() != 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICAL_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder answer = new StringBuilder();



        Arrays.stream(gson.fromJson(readMechanicsFromFile(), MechanicJsonImportDto[].class))
                .forEach(c -> {
                            try {
                                if(!Validate.checkIfItsValid(c)){
                                    throw new Exception("fuck");
                                }
                                mechanicsRepository.saveAndFlush(c.toMechanics());
                                answer.append("Successfully imported mechanic ").
                                        append(c.getFirstName()).
                                        append(" ").
                                        append(c.getLastName()).
                                        append(String.format("%n"));
                            }catch (Exception e){
                                answer.append("Invalid mechanic").
                                        append(String.format("%n"));
                            }

                        }
                );

        return answer.toString();
    }
}
