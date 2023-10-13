package com.resellerapp.model.dtos;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionConstants;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ViewOffer {

    private Long id;
    private String description;
    private BigDecimal price;
    private ConditionConstants condition;

    public ViewOffer(Offer offer) {
        this.id = offer.getId();
        this.description = offer.getDescription();
        this.price = offer.getPrice();
        this.condition = offer.getCondition().getName();
    }
}
