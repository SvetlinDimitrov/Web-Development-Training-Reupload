package com.example.mobileleweb.domain.viewDtos;

import com.example.mobileleweb.domain.constants.Engine;
import com.example.mobileleweb.domain.constants.Transmission;
import com.example.mobileleweb.domain.entity.Offer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ViewOfferDto {

    private String id;

    @NotBlank
    private String description;

    @NotNull
    private Engine engine;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Integer mileage;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer year;

    @NotNull
    private Transmission transmission;

    private LocalDate created = LocalDate.now();

    private LocalDate modified = LocalDate.now();

    @NotBlank
    private String modelId;

    private String sellerId;

    private String offerYear_BrandName_OfferName;


    public Offer toOffer() {
        return Offer.builder()
                .engine(engine)
                .imageUrl(imageUrl)
                .mileage(mileage)
                .description(description)
                .price(price)
                .transmission(transmission)
                .year(year)
                .created(created)
                .modified(modified)
                .build();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewOfferDto that = (ViewOfferDto) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && engine == that.engine && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(mileage, that.mileage) && Objects.equals(price, that.price) && Objects.equals(year, that.year) && transmission == that.transmission && Objects.equals(created, that.created) && Objects.equals(modified, that.modified) && Objects.equals(modelId, that.modelId) && Objects.equals(sellerId, that.sellerId) && Objects.equals(offerYear_BrandName_OfferName, that.offerYear_BrandName_OfferName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, engine, imageUrl, mileage, price, year, transmission, created, modified, modelId, sellerId, offerYear_BrandName_OfferName);
    }
}
