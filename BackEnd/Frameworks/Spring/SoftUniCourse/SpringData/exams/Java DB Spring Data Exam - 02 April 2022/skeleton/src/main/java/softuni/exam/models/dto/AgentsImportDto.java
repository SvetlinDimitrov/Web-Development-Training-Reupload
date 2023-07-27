package softuni.exam.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AgentsImportDto {
    //    • first name – accepts char sequences as values where their character length value higher than or equal to 2. The values are unique in the database.
    //    • last name – accepts char sequences as values where their character length value higher than or equal to 2.
    //    • email – an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
    //    • Constraint: The agents table has а relation with the towns table.

    @NotBlank
    @Size(min = 2)
    private String firstName;
    @NotBlank
    @Size(min = 2)
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String town;

    public String getFirstName() {
        return firstName;
    }

    public AgentsImportDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AgentsImportDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AgentsImportDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTown() {
        return town;
    }

    public AgentsImportDto setTown(String town) {
        this.town = town;
        return this;
    }
}
