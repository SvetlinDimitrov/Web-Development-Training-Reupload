package softuni.exam.models.dto.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.Part;

import javax.validation.constraints.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartsJsonImportDto {

    @Size(min = 2 , max = 19)
    @NotBlank
    private String partName;

    @DecimalMin(value = "10.0")
    @DecimalMax(value = "2000.0")
    @NotNull
    private Double price;

    @Positive
    @NotNull
    private Integer quantity;

    public Part toPart(){
        return Part.builder().
                partName(partName).
                price(price).
                quantity(quantity)
                .build();
    }

}
