package softuni.exam.service.impl;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.PartsJsonImportDto;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.Validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class PartsServiceImpl implements PartsService {
    private PartsRepository partsRepository;
    private Gson gson;
    private final static String PART_FILE_PATH = "src/main/resources/files/json/parts.json";

    @Override
    public boolean areImported() {
        return partsRepository.count() != 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PART_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder answer = new StringBuilder();

        Arrays.stream(gson.fromJson(readPartsFileContent(), PartsJsonImportDto[].class))
                .forEach(p -> {
                            try {
                                if(!Validate.checkIfItsValid(p)){
                                    throw new Exception("fuck");
                                }
                                partsRepository.saveAndFlush(p.toPart());
                                answer.append("Successfully imported part ").
                                        append(p.getPartName()).
                                        append(" - ").
                                        append(p.getPrice()).
                                        append(String.format("%n"));
                            }catch (Exception e){
                                answer.append("Invalid part").
                                        append(String.format("%n"));
                            }

                        }
                );

        return answer.toString();
    }
}
