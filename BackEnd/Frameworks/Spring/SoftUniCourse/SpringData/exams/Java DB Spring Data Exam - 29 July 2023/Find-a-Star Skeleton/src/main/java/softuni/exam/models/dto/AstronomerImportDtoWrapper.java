package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "astronomers")
public class AstronomerImportDtoWrapper {

    @XmlElement(name = "astronomer")
    private List<AstronomerImportDto> astronomers;

    public List<AstronomerImportDto> getAstronomers() {
        return astronomers;
    }

    public AstronomerImportDtoWrapper setAstronomers(List<AstronomerImportDto> astronomers) {
        this.astronomers = astronomers;
        return this;
    }
}
