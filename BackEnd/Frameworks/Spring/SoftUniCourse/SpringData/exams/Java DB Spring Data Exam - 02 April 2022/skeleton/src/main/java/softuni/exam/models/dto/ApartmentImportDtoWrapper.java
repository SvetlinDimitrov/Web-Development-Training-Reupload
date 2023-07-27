package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentImportDtoWrapper {
    @XmlElement(name = "apartment")
    List<ApartmentImportDto> list;

    public List<ApartmentImportDto> getList() {
        return list;
    }

    public ApartmentImportDtoWrapper setList(List<ApartmentImportDto> list) {
        this.list = list;
        return this;
    }
}
