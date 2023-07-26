package softuni.exam.models.dto.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.Car;
import softuni.exam.util.CarType;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsXmlDto {

    @XmlElement
    @NotNull
    private CarType carType;

    @XmlElement
    @Size(min = 2, max = 30)
    @NotBlank
    private String carMake;

    @XmlElement
    @Size(min = 2, max = 30)
    @NotBlank
    private String carModel;

    @XmlElement
    @Positive
    @NotNull
    private Integer year;

    @XmlElement
    @Size(min = 2, max = 30)
    @NotBlank
    private String plateNumber;

    @XmlElement
    @NotNull
    @Positive
    private Integer kilometers;

    @XmlElement
    @DecimalMin("1.00")
    @NotNull
    private Double engine;

    public Car toCar() {
        return Car.builder().
                carType(carType).
                carMake(carMake).
                carModel(carModel).
                year(year).
                plateNumber(plateNumber).
                kilometers(kilometers).
                engine(engine).
                build();
    }
}
