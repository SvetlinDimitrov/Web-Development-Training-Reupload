package softuni.exam.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "astronomer")
public class AstronomerImportDto {

    //    • first name - accepts char sequence (between 2 to 30 inclusive).
    //    • last name - accepts char sequence (between 2 to 30 inclusive).
    //    • salary - accepts number values that are more than or equal to 15000.00.
    //    • averageObservationHours - accepts number values that are more than 500.00.
    //    • birthday - a date in the "yyyy-MM-dd" format. Can be nullable.
    //    • observing star - the current star that the astronomer is studying.

    @NotBlank
    @XmlElement(name = "first_name")
    @Size(min = 2 , max = 30)
    private String firstName;

    @NotBlank
    @XmlElement(name = "last_name")
    @Size(min = 2 , max = 30)
    private String lastName;

    @NotNull
    @DecimalMin(value = "15000.00")
    @XmlElement(name = "salary")
    private Double salary;

    @NotNull
    @DecimalMin(value = "500.00")
    @XmlElement(name = "average_observation_hours")
    private Double averageObservationHours;

    @XmlElement(name = "birthday")
    private String birthday;

    @NotNull
    @XmlElement(name = "observing_star_id")
    private Long observingStarId;

    public String getFirstName() {
        return firstName;
    }

    public AstronomerImportDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AstronomerImportDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public AstronomerImportDto setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public AstronomerImportDto setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public AstronomerImportDto setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public Long getObservingStarId() {
        return observingStarId;
    }

    public AstronomerImportDto setObservingStarId(Long observingStarId) {
        this.observingStarId = observingStarId;
        return this;
    }
}
