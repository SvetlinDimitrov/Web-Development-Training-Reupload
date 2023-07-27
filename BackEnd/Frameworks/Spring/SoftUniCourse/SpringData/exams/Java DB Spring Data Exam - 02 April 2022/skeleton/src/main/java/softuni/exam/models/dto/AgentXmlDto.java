package softuni.exam.models.dto;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "agent")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentXmlDto {
    public String getName() {
        return name;
    }

    public AgentXmlDto setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank
    @XmlElement
    private String name;
}
