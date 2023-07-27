package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentXmlDto {
    @NotNull
    @XmlElement
    private Long id;

    public Long getId() {
        return id;
    }

    public ApartmentXmlDto setId(Long id) {
        this.id = id;
        return this;
    }
}
