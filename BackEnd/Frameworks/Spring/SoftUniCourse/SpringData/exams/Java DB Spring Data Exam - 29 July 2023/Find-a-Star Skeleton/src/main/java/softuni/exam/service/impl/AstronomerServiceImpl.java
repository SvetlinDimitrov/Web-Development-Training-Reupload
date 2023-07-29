package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportDto;
import softuni.exam.models.dto.AstronomerImportDtoWrapper;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.Validate;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private final AstronomerRepository astronomerRepository;
    private final static Set<String> names = new HashSet<>();
    private final StarRepository starRepository;
    private final static String PATH_FILE = "src/main/resources/files/xml/astronomers.xml";

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() != 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();
        long maxIdOfStars = starRepository.count();

        XmlParser.fromFile(Path.of(PATH_FILE).toFile(), AstronomerImportDtoWrapper.class)
                .getAstronomers()
                .forEach(a -> {

                    if (!Validate.checkIfItsValid(a) ||
                            names.contains(String.format("%s %s", a.getFirstName(), a.getLastName())) ||
                            maxIdOfStars < a.getObservingStarId()
                    ){

                        builder.append("Invalid astronomer")
                                .append(System.lineSeparator());

                        return;
                    }

                    names.add(String.format("%s %s", a.getFirstName(), a.getLastName()));

                    Astronomer astronomer = toAstronomer(a);
                    astronomerRepository.save(astronomer);
                    builder.append(String.format("Successfully imported astronomer %s - %.2f",
                                    String.format("%s %s" , a.getFirstName() , a.getLastName()),
                                    a.getAverageObservationHours()))
                            .append(System.lineSeparator());

                });

        names.clear();
        return builder.toString();
    }
    private Astronomer toAstronomer(AstronomerImportDto dto){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return new Astronomer()
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setSalary(dto.getSalary())
                .setAverageObservationHours(dto.getAverageObservationHours())
                .setBirthday(dto.getBirthday() != null ? LocalDate.parse(dto.getBirthday() , dateTimeFormatter) : null)
                .setObservingStar(starRepository.findById(dto.getObservingStarId()).orElseThrow());
    }
}
