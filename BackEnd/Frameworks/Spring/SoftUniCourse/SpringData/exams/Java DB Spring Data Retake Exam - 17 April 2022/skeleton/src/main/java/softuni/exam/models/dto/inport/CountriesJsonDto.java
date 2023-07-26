package softuni.exam.models.dto.inport;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CountriesJsonDto {

    @Size(min = 2 , max = 60)
    @NotBlank
    private String countryName;
    @Size(min = 2 , max = 60)
    @NotBlank
    private String currency;

    public String getCountryName() {
        return countryName;
    }

    public CountriesJsonDto setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public CountriesJsonDto setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
