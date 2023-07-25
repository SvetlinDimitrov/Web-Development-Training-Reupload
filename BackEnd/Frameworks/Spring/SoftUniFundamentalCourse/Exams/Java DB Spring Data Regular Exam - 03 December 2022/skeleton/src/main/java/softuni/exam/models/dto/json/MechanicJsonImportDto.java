package softuni.exam.models.dto.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.Mechanics;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MechanicJsonImportDto {

    @Size(min = 2)
    @NotBlank
    private String firstName;
    @Size(min = 2)
    @NotBlank
    private String lastName;
    @Email
    @NotBlank
    private String email;
    @Size(min = 2)
    private String phone;

    public Mechanics toMechanics(){
        return Mechanics.builder().
                firstName(firstName).
                lastName(lastName).
                email(email).
                phone(phone).
                build();
    }

}
