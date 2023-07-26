package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Country extends BaseEntity{

    //    • country name – accepts char sequence (between 2 to 60 inclusive). The values are unique in the database. Cannot be null.
    //    • currency – accepts char sequences (between 2 and 20 inclusive). Cannot be null.

    @Column(unique = true , nullable = false , columnDefinition = "varchar(255)")
    private String countryName;

    @Column(nullable = false , columnDefinition = "varchar(255)")
    private String currency;

    public String getCountryName() {
        return countryName;
    }

    public Country setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Country setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
