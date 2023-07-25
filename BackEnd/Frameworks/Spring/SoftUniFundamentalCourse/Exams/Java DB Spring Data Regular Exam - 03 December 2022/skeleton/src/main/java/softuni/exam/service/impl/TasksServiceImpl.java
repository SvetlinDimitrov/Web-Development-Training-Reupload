package softuni.exam.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.TaskXmlDto;
import softuni.exam.models.dto.xml.TaskXmlWrapperDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.CarType;
import softuni.exam.util.Validate;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@AllArgsConstructor
public class TasksServiceImpl implements TasksService {
    private TasksRepository tasksRepository;
    private MechanicsRepository mechanicsRepository;
    private CarsRepository carsRepository;
    private PartsRepository partsRepository;
    private XmlParser xmlParser;
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    @Override
    public boolean areImported() {
        return tasksRepository.count() != 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();
        xmlParser.fromFile(Path.of(TASKS_FILE_PATH).toFile(), TaskXmlWrapperDto.class)
                .getTasks()
                .forEach(c -> {
                    try {
                        if (!Validate.checkIfItsValid(c) ||
                                !Validate.checkIfItsValid(c.getCar()) ||
                                !Validate.checkIfItsValid(c.getMechanic()) ||
                                !Validate.checkIfItsValid(c.getPart())) {
                            throw new Exception();
                        }
                        Task task = toTask(c);
                        if (
                                task.getMechanic() == null ||
                                        task.getParts() == null ||
                                        task.getCars() == null) {
                            throw new Exception();
                        }
                        tasksRepository.saveAndFlush(task);
                        builder.append("Successfully imported task ").
                                append(task.getPrice()).
                                append(System.lineSeparator());
                    } catch (Exception e) {
                        builder.append("Invalid task").
                                append(System.lineSeparator());
                    }
                });
        return builder.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder builder = new StringBuilder();
        carsRepository.findAll()
                .stream()
                .flatMap(c->c.getTask().stream())
                .filter(t -> t.getCars().getCarType().equals(CarType.coupe))
                .sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
                .forEach(p -> {
                    builder.append(String.format("Car %s %s with %dkm",
                                    p.getCars().getCarMake(),
                                    p.getCars().getCarModel(),
                                    p.getCars().getKilometers()))
                            .append(System.lineSeparator())
                            .append(String.format("-Mechanic: %s %s - task №%d:",
                                    p.getMechanic().getFirstName(),
                                    p.getMechanic().getLastName(),
                                    p.getId()))
                            .append(System.lineSeparator())
                            .append(String.format(" --Engine: %s",
                                    p.getCars().getEngine()))
                            .append(System.lineSeparator())
                            .append(String.format("---Price: %.2f$",
                                    p.getPrice()))
                            .append(System.lineSeparator())
                            ;
                });

        return builder.toString();
    }

    private Task toTask(TaskXmlDto dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return Task.builder().
                price(dto.getPrice().setScale(2, RoundingMode.HALF_UP)).
                date(LocalDateTime.parse(dto.getDate(), formatter)).
                mechanic(mechanicsRepository.findByFirstName(dto.getMechanic().getFirstName())).
                parts(partsRepository.findById(dto.getPart().getId()).get()).
                cars(carsRepository.findById(dto.getCar().getId()).get()).
                build();

    }
}
