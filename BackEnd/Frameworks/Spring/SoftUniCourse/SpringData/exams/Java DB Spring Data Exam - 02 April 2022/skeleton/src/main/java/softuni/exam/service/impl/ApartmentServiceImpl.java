package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.ApartmentImportDto;
import softuni.exam.models.dto.ApartmentImportDtoWrapper;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.Validate;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final static String PATH_FILE = "src/main/resources/files/xml/apartments.xml";

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() != 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    @Transactional
    public String importApartments() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();

        XmlParser.fromFile(Path.of(PATH_FILE).toFile() , ApartmentImportDtoWrapper.class)
                .getList()
                .forEach(a->{
                    if(!Validate.checkIfItsValid(a) ||
                    townRepository.findByTownName(a.getTown()).isEmpty() ||
                            alreadyExists(townRepository.findByTownName(a.getTown()).get() , a)
                    ){
                        builder.append("Invalid apartment")
                                .append(System.lineSeparator());
                        return;
                    }

                    Apartment apartment = toApartment(a);
                    apartmentRepository.saveAndFlush(apartment);
                    townRepository.findByTownName(a.getTown()).orElseThrow().getApartments().add(apartment);

                    builder.append(String.format("Successfully imported apartment %s - %.2f",
                                    a.getApartmentType().name() ,
                                    a.getArea()))
                            .append(System.lineSeparator());
                });

        return builder.toString();
    }

    private boolean alreadyExists(Town town, ApartmentImportDto apartmentImportDto) {
        return town.getApartments().
                stream().
                anyMatch(a->(Double.compare(a.getArea() , apartmentImportDto.getArea()) == 0));
    }

    private Apartment toApartment(ApartmentImportDto apartmentImportDto){
        return new Apartment()
                .setApartmentType(apartmentImportDto.getApartmentType())
                .setArea(apartmentImportDto.getArea())
                .setTown(townRepository.findByTownName(apartmentImportDto.getTown()).orElseThrow());
    }
}
