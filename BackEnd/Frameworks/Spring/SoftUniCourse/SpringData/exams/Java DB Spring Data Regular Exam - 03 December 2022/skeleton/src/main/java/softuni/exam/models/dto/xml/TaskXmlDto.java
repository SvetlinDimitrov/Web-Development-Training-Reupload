package softuni.exam.models.dto.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanics;
import softuni.exam.models.entity.Part;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskXmlDto {

    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;

    @XmlElement
    @NotBlank
    private String date;


    @XmlElement(name = "car")
    private CarXmlDto2 car;

    @XmlElement(name = "part")
    private PartXmlDto part;

    @XmlElement(name = "mechanic")
    private MechanicXmlDto mechanic;


}
