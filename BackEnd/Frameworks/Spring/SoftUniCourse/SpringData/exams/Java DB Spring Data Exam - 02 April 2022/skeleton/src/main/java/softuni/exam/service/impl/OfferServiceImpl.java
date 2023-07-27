package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.ApartmentImportDtoWrapper;
import softuni.exam.models.dto.OfferImportDto;
import softuni.exam.models.dto.OfferImportDtoWrapper;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.Validate;
import softuni.exam.util.XmlParser;
import softuni.exam.util.enums.ApartmentType;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final static String PATH_FILE = "src/main/resources/files/xml/offers.xml";

    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() != 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(PATH_FILE));
    }

    @Override
    @Transactional
    public String importOffers() throws IOException, JAXBException {
        StringBuilder builder = new StringBuilder();

        XmlParser.fromFile(Path.of(PATH_FILE).toFile() , OfferImportDtoWrapper.class)
                .getOffers()
                .forEach(o->{
                    if(!Validate.checkIfItsValid(o) ||
                    agentRepository.findByFirstName(o.getAgent().getName()).isEmpty() ||
                    apartmentRepository.findById(o.getApartment().getId()).isEmpty()){
                        builder.append("Invalid offer")
                                .append(System.lineSeparator());
                        return;
                    }

                    Offer offer = toOffer(o);
                    offerRepository.save(offer);
                    Agent agent = offer.getAgent();
                    agent.getOffers().add(offer);
                    agentRepository.save(agent);
                    Apartment apartment = offer.getApartment();
                    apartment.getOffers().add(offer);
                    apartmentRepository.save(apartment);

                    builder.append(String.format("Successfully imported offer %s",
                                    o.getPrice().setScale(2, RoundingMode.HALF_UP)))
                            .append(System.lineSeparator());
                });

        return builder.toString();
    }

    @Override
    @Transactional
    public String exportOffers() {
        StringBuilder builder = new StringBuilder();

        offerRepository.extractData(ApartmentType.three_rooms)
                .forEach(o->
                            builder.append(String.format("Agent %s %s with offer №%d:",
                                            o.getAgent().getFirstName(),
                                            o.getAgent().getLastName(),
                                            o.getId()))
                                    .append(System.lineSeparator())
                                    .append(String.format("-Apartment area: %.2f",
                                            o.getApartment().getArea()))
                                    .append(System.lineSeparator())
                                    .append(String.format("--Town: %s",
                                            o.getApartment().getTown().getTownName()))
                                    .append(System.lineSeparator())
                                    .append(String.format("---Price: %s$",
                                            o.getPrice().setScale(2 , RoundingMode.HALF_UP)))
                                    .append(System.lineSeparator())
                        );

        return builder.toString();
    }

    private Offer toOffer(OfferImportDto offerImportDto){
        return new Offer()
                .setPublishedOn(LocalDate.parse(offerImportDto.getPublishedOn(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setApartment(apartmentRepository.findById(offerImportDto.getApartment().getId()).orElseThrow())
                .setAgent(agentRepository.findByFirstName(offerImportDto.getAgent().getName()).orElseThrow())
                .setPrice(offerImportDto.getPrice());
    }
}
