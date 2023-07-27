package softuni.exam.models.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDto {
    //    • price – accepts a positive number.
    //    • published on – a date in the "dd/MM/yyyy" format.
    //    • Constraint: The offers table has a relation with the apartments table.
    //    • Constraint: The offers table has a relation with the agents table.


    @NotNull
    @Positive
    @XmlElement
    private BigDecimal price;

    @NotNull
    @XmlElement
    private String publishedOn;

    @XmlElement
    private AgentXmlDto agent;
    @XmlElement
    private ApartmentXmlDto apartment;

    public BigDecimal getPrice() {
        return price;
    }

    public OfferImportDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public OfferImportDto setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
        return this;
    }

    public AgentXmlDto getAgent() {
        return agent;
    }

    public OfferImportDto setAgent(AgentXmlDto agent) {
        this.agent = agent;
        return this;
    }

    public ApartmentXmlDto getApartment() {
        return apartment;
    }

    public OfferImportDto setApartment(ApartmentXmlDto apartment) {
        this.apartment = apartment;
        return this;
    }
}
