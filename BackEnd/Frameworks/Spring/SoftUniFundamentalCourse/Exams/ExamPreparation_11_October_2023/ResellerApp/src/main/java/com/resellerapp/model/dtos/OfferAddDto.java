package com.resellerapp.model.dtos;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionConstants;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.function.Supplier;

@Data
public class OfferAddDto {

    @NotBlank
    @Length(min = 2 , max = 50)
    private String description;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal price;

    @NotNull
    private ConditionConstants condition;

    public Supplier<Offer> toOffer = () -> {
        Offer offer = new Offer();
        offer.setDescription(description);
        offer.setPrice(price);
        return offer;
    };

}
