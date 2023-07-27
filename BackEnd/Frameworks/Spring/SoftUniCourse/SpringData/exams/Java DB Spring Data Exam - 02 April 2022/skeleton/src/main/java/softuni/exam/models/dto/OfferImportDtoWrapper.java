package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDtoWrapper {
    public List<OfferImportDto> getOffers() {
        return offers;
    }

    public OfferImportDtoWrapper setOffers(List<OfferImportDto> offers) {
        this.offers = offers;
        return this;
    }

    @XmlElement(name = "offer")
    List<OfferImportDto> offers;
}
