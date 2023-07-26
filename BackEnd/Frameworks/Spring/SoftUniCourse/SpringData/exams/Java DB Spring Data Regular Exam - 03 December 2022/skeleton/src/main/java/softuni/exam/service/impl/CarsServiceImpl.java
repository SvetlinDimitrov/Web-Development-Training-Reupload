package softuni.exam.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.CarsXmlDto;
import softuni.exam.models.dto.xml.CarsXmlWrapperDto;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.Validate;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@AllArgsConstructor
public class CarsServiceImpl implements CarsService {
    private CarsRepository carsRepository;
    private XmlParser xmlParser;
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    @Override
    public boolean areImported() {
        return carsRepository.count() != 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return  Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();
        xmlParser.fromFile(Path.of(CARS_FILE_PATH).toFile() , CarsXmlWrapperDto.class)
                .getCars()
                .forEach(c->{
                    try{
                        if(!Validate.checkIfItsValid(c)){
                            throw new Exception();
                        }
                        carsRepository.saveAndFlush(c.toCar());
                        builder.append("Successfully imported car ").
                                append(c.getCarMake()).
                                append(" - ").
                                append(c.getCarModel()).
                                append(System.lineSeparator());
                    }catch (Exception e){
                        builder.append("Invalid car").
                                append(System.lineSeparator());
                    }
                });
        return builder.toString();
    }

}
