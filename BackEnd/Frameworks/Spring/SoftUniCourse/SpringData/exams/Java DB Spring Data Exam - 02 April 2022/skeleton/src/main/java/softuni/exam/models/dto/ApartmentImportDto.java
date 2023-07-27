package softuni.exam.models.dto;

import softuni.exam.util.enums.ApartmentType;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentImportDto {
    //    • apartment type – the enumeration, one of the following – two_rooms, three_rooms, four_rooms
    //    • area – accepts number values that are more than or equal to 40.00.
    //    • Constraint: The apartment table has а relation with the towns table.

    @XmlElement(name = "apartmentType")
    @NotNull
    private ApartmentType apartmentType;

    @XmlElement(name = "area")
    @NotNull
    @DecimalMin(value = "40.00")
    private Double area;

    @XmlElement(name = "town")
    @NotBlank
    private String town;

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public ApartmentImportDto setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
        return this;
    }

    public Double getArea() {
        return area;
    }

    public ApartmentImportDto setArea(Double area) {
        this.area = area;
        return this;
    }

    public String getTown() {
        return town;
    }

    public ApartmentImportDto setTown(String town) {
        this.town = town;
        return this;
    }
}
